package net.dlcruz.springboot.console.template.test

import io.swagger.annotations.Api
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/test")
@Api(tags = ["/claim"], description = "Operations on a claim")
class TestController(val testService: TestService, val modelMapper: ModelMapper) {

    @GetMapping
    fun list(): ResponseEntity<Flux<Test>> {
        val dtoList = testService.list().map { modelMapper.map(it, Test::class.java) }
        return ResponseEntity(dtoList, HttpStatus.OK)
    }
}