package net.dlcruz.springboot.console.template.test

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.scheduler.Scheduler

@Service
class TestService(val testRepository: TestRepository, val scheduler: Scheduler) {

    fun list(): Flux<PersistentTest> {
        var defer = Flux.defer { Flux.fromIterable(testRepository.findAll()) }
        return defer.subscribeOn(scheduler)
    }
}