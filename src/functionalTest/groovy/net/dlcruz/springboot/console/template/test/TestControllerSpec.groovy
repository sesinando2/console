package net.dlcruz.springboot.console.template.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TestControllerSpec extends Specification {

    @Autowired
    TestRepository testRepository

    @Autowired
    TestRestTemplate restTemplate

    void 'functional test'() {
        given:
        def persistentTest = testRepository.save(new PersistentTest())

        when:
        def response = restTemplate.getForEntity('/test', Object)

        then:
        response.statusCode == HttpStatus.OK
        !response.body*.id.empty
    }
}
