package net.dlcruz.gradle.liquibase

class LiquibaseChangelogDiffTask extends LiquibaseTask {

    DiffType type = DiffType.HIBERNATE

    @Override
    protected void addLiquibaseArgs() {
        def reason = project.hasProperty('reason') ? project.reason : 'put-reason-here'
        args "--changeLogFile=${project.projectDir}/src/main/resources/${config.directory}/migrations/${new Date().format('yyMMdd')}-${reason}.${config.fileExtension}"

        switch (type) {
            case DiffType.HIBERNATE:
                args "--url=${config.url}"
                args "--username=${config.username}"
                args "--driver=${config.driver}"
                args "--referenceUrl=hibernate:spring:${config.jpaPackage}?dialect=org.hibernate.dialect.MySQL5Dialect&hibernate.physical_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy&hibernate.implicit_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy"
                args "--referenceDriver=liquibase.ext.hibernate.database.connection.HibernateDriver"
                args "--logLevel=${config.logLevel}"

                break

            case DiffType.DB:
                args "--referenceUrl=${config.url}"
                args "--referenceUsername=${config.username}"
                args "--referenceDriver=${config.driver}"
                args "--url=hibernate:spring:${config.jpaPackage}?dialect=org.hibernate.dialect.MySQL5Dialect&hibernate.physical_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy&hibernate.implicit_naming_strategy=org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy"
                args "--referenceDriver=liquibase.ext.hibernate.database.connection.HibernateDriver"
                args "--logLevel=${config.logLevel}"

                break
        }

        args "diffChangeLog"
    }
}

enum DiffType {
    DB, HIBERNATE
}
