package br.com.bitencourt.config

import br.com.bitencourt.adapters.out.FindPersonByIdAdapter
import br.com.bitencourt.application.core.usecase.FindPersonByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindPersonByIdConfig {

    @Bean
    fun findPersonById(findPersonByIdAdapter: FindPersonByIdAdapter) = FindPersonByIdUseCase(findPersonByIdAdapter)
}