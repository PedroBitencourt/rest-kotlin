package br.com.bitencourt.adapters.`in`.controller

import br.com.bitencourt.adapters.`in`.controller.request.PersonRequest
import br.com.bitencourt.adapters.`in`.controller.response.PersonResponse
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.`in`.FindAllPersonInputPort
import br.com.bitencourt.application.ports.`in`.FindPersonByIdInputPort
import br.com.bitencourt.application.ports.`in`.InsertPersonInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(
    private val insertPersonInputPort: InsertPersonInputPort,
    private val findPersonByIdInputPort: FindPersonByIdInputPort,
    private val findAllPersonInputPort: FindAllPersonInputPort) {

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: Long) = PersonResponse(findPersonByIdInputPort.find(id))

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll() = findAllPersonInputPort.find().map { PersonResponse(it) }
}