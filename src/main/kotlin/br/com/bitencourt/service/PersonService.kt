package br.com.bitencourt.service

import br.com.bitencourt.domain.dto.request.PersonCreateRequest
import br.com.bitencourt.domain.dto.request.PersonUpdateRequest
import br.com.bitencourt.domain.dto.response.PersonResponse
import br.com.bitencourt.exception.ResourceNotFoundException
import br.com.bitencourt.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PersonService {

    @Autowired
    lateinit var repository: PersonRepository

    fun findAll(): List<PersonResponse> = repository.findAll().map { PersonResponse(it) }

    fun findById(id: Long) = PersonResponse(repository.findById(id)
                                .orElseThrow{ ResourceNotFoundException("No records found for this ID!")})

    fun createPerson(request: PersonCreateRequest) = PersonResponse(repository.save(request.toPerson()))

    fun deletePerson(id: Long) = repository.deleteById(id)

    fun updatePerson(request: PersonUpdateRequest): PersonResponse {
        val person = repository.findById(request.id)
                        .orElseThrow{ ResourceNotFoundException("No records found for this ID!")}

        request.firstName?.let { person.firstName = it }
        request.lastName?.let { person.lastName = it }
        request.address?.let { person.address = it }
        request.phone?.let { person.phone = it }

        return PersonResponse(repository.save(person))
    }
}