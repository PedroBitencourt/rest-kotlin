package br.com.bitencourt.domain.dto.response

import br.com.bitencourt.domain.entity.Person

data class PersonResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val address: String,
    val phone: String
) {
    constructor(person: Person) : this(
        id = person.id,
        firstName = person.firstName,
        lastName = person.lastName,
        address = person.address,
        phone = person.phone
    )
}
