package br.com.bitencourt.adapters.out

import br.com.bitencourt.adapters.out.repository.PersonRepository
import br.com.bitencourt.adapters.out.repository.entity.PersonEntity
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.out.InsertPersonOutPutPort
import org.springframework.stereotype.Component

@Component
class InsertPersonAdapter(private val personRepository: PersonRepository): InsertPersonOutPutPort {
    override fun insert(person: Person) {
        personRepository.save(PersonEntity(person))
    }
}