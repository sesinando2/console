package net.dlcruz.springboot.console.template.test

import org.springframework.core.task.SyncTaskExecutor
import reactor.core.scheduler.Schedulers
import spock.lang.Specification
import spock.lang.Subject

class TestServiceSpec extends Specification {

    @Subject
    TestService testService

    TestRepository testRepository

    void setup() {
        testRepository = Mock()
        testService = new TestService(testRepository, Schedulers.fromExecutor(new SyncTaskExecutor()))
    }

    void 'unit test' () {
        when:
        def result = testService.list().collectList().blockOptional().get()

        then:
        result == []
        1 * testRepository.findAll() >> ([])
    }
}
