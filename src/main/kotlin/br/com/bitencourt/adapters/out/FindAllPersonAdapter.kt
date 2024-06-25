package br.com.bitencourt.adapters.out

import br.com.bitencourt.adapters.out.repository.PersonRepository
import br.com.bitencourt.application.ports.out.FindAllPersonOutputPort
import org.springframework.stereotype.Component

@Component
class FindAllPersonAdapter(private val personRepository: PersonRepository): FindAllPersonOutputPort {
    override fun find() = personRepository.findAll().map { it.toPerson() }
}