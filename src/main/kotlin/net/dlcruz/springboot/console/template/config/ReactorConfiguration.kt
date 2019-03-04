package net.dlcruz.springboot.console.template.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Executor

@Configuration
class ReactorConfiguration {

    @Bean
    fun scheduler(executor: Executor): Scheduler {
        return Schedulers.fromExecutor(executor)
    }
}