package br.com.bitencourt.config

import br.com.bitencourt.adapters.out.FindAllPersonAdapter
import br.com.bitencourt.application.core.usecase.FindAllPersonUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindAllPersonConfig {

    @Bean
    fun findAllPerson(findAllPersonAdapter: FindAllPersonAdapter) = FindAllPersonUseCase(findAllPersonAdapter)
}