package net.dlcruz.springboot.console.template.test

import net.dlcruz.springboot.console.template.config.FunctionalTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@FunctionalTest
class TestControllerSpec extends Specification {

    @Autowired
    TestRepository testRepository

    @Autowired
    TestRestTemplate restTemplate

    void 'functional test'() {
        given:
        def persistentTest = testRepository.save(new PersistentTest())

        when:
        def response = restTemplate.getForEntity('/test', List)

        then:
        response.statusCode == HttpStatus.OK

        when:
        def list = response.body as List<Test>

        then:
        list.find { it.id == persistentTest.id }
    }
}
