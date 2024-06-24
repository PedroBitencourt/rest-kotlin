package br.com.bitencourt.adapters.`in`.controller

import br.com.bitencourt.adapters.`in`.controller.request.PersonRequest
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.`in`.InsertPersonInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(private val insertPersonInputPort: InsertPersonInputPort) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody personRequest: PersonRequest) {
        with(personRequest) {
            val person = Person(
                firstName = firstName,
                lastName = lastName,
                phone = phone
            )
            insertPersonInputPort.insert(person, zipCode)
        }
    }
}