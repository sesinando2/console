package net.dlcruz.springboot.console.template.test

import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController(val testService: TestService, val modelMapper: ModelMapper) {

    @GetMapping
    fun list(): ResponseEntity<List<Test>> {
        val list = testService.list()
        val dtoList = list.map { modelMapper.map(it, Test::class.java) }
        return ResponseEntity(dtoList, HttpStatus.OK)
    }
}