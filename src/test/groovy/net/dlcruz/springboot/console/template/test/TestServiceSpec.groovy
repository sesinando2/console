package net.dlcruz.springboot.console.template.test

import spock.lang.Specification
import spock.lang.Subject

class TestServiceSpec extends Specification {

    @Subject
    TestService testService

    TestRepository testRepository

    void setup() {
        testRepository = Mock()
        testService = new TestService(testRepository)
    }

    void 'unit test' () {
        when:
        def result = testService.list()

        then:
        result == []

        and:
        1 * testRepository.findAll() >> []
    }
}
