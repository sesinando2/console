package net.dlcruz.gradle.liquibase

import org.gradle.api.Plugin
import org.gradle.api.Project

class LiquibasePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def extension = project.extensions.create('liquibaseConfig', LiquibaseExtension)

        project.configurations {
            liquibase
        }

        project.dependencies {
            liquibase('org.liquibase:liquibase-core')
            liquibase('org.liquibase.ext:liquibase-hibernate5:3.6')
            liquibase('org.springframework.boot:spring-boot-starter-data-jpa')
        }

        project.task('testPlugin') {
            doLast {
                println "${extension.driver}"
            }
        }

        project.task([type: LiquibaseTask], 'liquibase') {
            config = extension
        }
        project.task([type: LiquibaseChangelogDiffTask], 'diffHibernate') {
            config = extension
        }
        project.task([type: LiquibaseChangelogDiffTask], 'diffDB') {
            config = extension
            type = DiffType.DB
        }
    }
}
