package br.com.bitencourt.adapters.out

import br.com.bitencourt.adapters.out.repository.AddressRepository
import br.com.bitencourt.adapters.out.repository.PersonRepository
import br.com.bitencourt.adapters.out.repository.entity.PersonEntity
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.out.InsertPersonOutputPort
import org.springframework.stereotype.Component

@Component
class InsertPersonAdapter(private val personRepository: PersonRepository, private val addressRepository: AddressRepository): InsertPersonOutputPort {
    override fun insert(person: Person) {
        val entity = PersonEntity(person)
        personRepository.save(entity)
        entity.address?.let { addressRepository.save(it) }
    }
}