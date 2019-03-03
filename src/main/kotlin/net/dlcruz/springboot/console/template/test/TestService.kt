package net.dlcruz.springboot.console.template.test

import org.springframework.stereotype.Service

@Service
class TestService(val testRepository: TestRepository) {

    fun list(): List<PersistentTest> {
        return testRepository.findAll()
    }
}