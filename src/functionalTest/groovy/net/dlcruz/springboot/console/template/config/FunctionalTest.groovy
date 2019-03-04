package net.dlcruz.springboot.console.template.config

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles(['dev', 'functionalTest'])
@interface FunctionalTest { }
