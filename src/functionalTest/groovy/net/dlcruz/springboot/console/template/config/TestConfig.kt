package net.dlcruz.springboot.console.template.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SyncTaskExecutor
import java.util.concurrent.Executor

@Configuration
class TestConfig {

    @Bean
    fun executor(): Executor {
        return SyncTaskExecutor()
    }
}