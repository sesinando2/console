package net.dlcruz.springboot.console.template.test

import org.springframework.core.task.SyncTaskExecutor
import reactor.core.scheduler.Schedulers
import reactor.test.StepVerifier
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
        given:
        def test1 = new PersistentTest(id: 1)
        def test2 = new PersistentTest(id: 2)

        and:
        testRepository.findAll() >> ([test1, test2])

        when:
        def source = testService.list()

        then:
        StepVerifier.create(source)
                .expectNext(test1)
                .expectNext(test2)
                .expectComplete()
                .verify()
    }
}
