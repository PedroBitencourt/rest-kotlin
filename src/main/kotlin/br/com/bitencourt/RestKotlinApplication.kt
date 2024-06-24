package br.com.bitencourt

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration

@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration::class)
@SpringBootApplication
class RestKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestKotlinApplication>(*args)
}
