package br.com.bitencourt.controller

import br.com.bitencourt.domain.dto.request.PersonCreateRequest
import br.com.bitencourt.domain.dto.request.PersonUpdateRequest
import br.com.bitencourt.domain.dto.response.PersonResponse
import br.com.bitencourt.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/persons")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping
    fun getAll(): ResponseEntity<List<PersonResponse>> = ResponseEntity.ok(service.findAll())

    @GetMapping("/{id}")
    fun getById(@PathVariable(value="id") id: Long): ResponseEntity<PersonResponse> = ResponseEntity.ok(service.findById(id))

    @PostMapping
    fun create(@RequestBody request: PersonCreateRequest): ResponseEntity<PersonResponse> {
       var person = service.createPerson(request)

       return ResponseEntity.status(HttpStatus.CREATED).body(person)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value="id") id: Long) :ResponseEntity<Void> {
        service.deletePerson(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping
    fun update(@RequestBody request: PersonUpdateRequest): ResponseEntity<PersonResponse> = ResponseEntity.ok(service.updatePerson(request))
}