package net.dlcruz.gradle.liquibase

import org.gradle.api.tasks.JavaExec

class LiquibaseTask extends JavaExec {

    LiquibaseExtension config

    LiquibaseTask() {
        group = 'liquibase'
        classpath project.sourceSets.main.runtimeClasspath
        classpath project.configurations.liquibase
        main = "liquibase.integration.commandline.Main"
    }

    @Override
    void exec() {
        addLiquibaseArgs()
        super.exec()
    }

    protected void addLiquibaseArgs() {
        args "--changeLogFile=${config.directory}/${config.changeLog}.${config.fileExtension}"
        args "--url=${config.url}"
        args "--username=${config.username}"
        args "--driver=${config.driver}"
        args "--logLevel=${config.logLevel}"

        if (config.password) {
            args "--password=${config.password}"
        }

        if (project.hasProperty('rollbackCount')) {
            args "rollbackCount"
            args "${project.rollbackCount}"
        } else if (project.hasProperty('update')) {
            args "update"
        } else if (project.hasProperty('status')) {
            args "status"
        } else if (project.hasProperty('generateChangeLog')) {
            args "generateChangelog"
        }
    }
}
