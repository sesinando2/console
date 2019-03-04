package net.dlcruz.springboot.console.template.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.SimpleApplicationEventMulticaster
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableAsync
class AsyncConfiguration {

    @Bean
    fun executor(): Executor {
        var executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 2
        executor.maxPoolSize = 10
        executor.setQueueCapacity(500)
        executor.setThreadGroupName("ConsoleAsync-")
        executor.initialize()
        return executor
    }

    @Bean
    fun applicationEventMulticaster(executor: Executor): ApplicationEventMulticaster {
        val applicationEventMulticaster = SimpleApplicationEventMulticaster()
        applicationEventMulticaster.setTaskExecutor(executor)
        return applicationEventMulticaster
    }
}