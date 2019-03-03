package net.dlcruz.springboot.console.template.test

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<PersistentTest, Long>