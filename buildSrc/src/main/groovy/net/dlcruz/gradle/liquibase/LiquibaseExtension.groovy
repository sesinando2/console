package net.dlcruz.gradle.liquibase

class LiquibaseExtension {

    String fileExtension = 'yml'

    String directory = 'db/changelog'
    String changeLog = 'db.changelog-master'

    String url
    String driver
    String username
    String password

    String jpaPackage

    String logLevel = 'info'
}
