databaseChangeLog {
  changeSet(id: '1551617860173-1', author: 'nando (generated)') {
    createTable(tableName: 'persistent_test') {
      column(name: 'id', type: 'BIGINT', autoIncrement: true) {
        constraints(primaryKey: true, primaryKeyName: 'persistent_testPK')
      }
    }
  }

}
