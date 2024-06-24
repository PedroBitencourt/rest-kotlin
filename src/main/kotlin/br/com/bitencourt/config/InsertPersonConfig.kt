package br.com.bitencourt.config

import br.com.bitencourt.adapters.out.FindAddressByZipCodeAdapter
import br.com.bitencourt.adapters.out.InsertPersonAdapter
import br.com.bitencourt.application.core.usecase.InsertPersonUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertPersonConfig {

    @Bean
    fun insertPerson(findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
                     insertPersonAdapter: InsertPersonAdapter) = InsertPersonUseCase(findAddressByZipCodeAdapter, insertPersonAdapter)
}