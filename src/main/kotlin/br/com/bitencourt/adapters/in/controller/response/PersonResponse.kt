package br.com.bitencourt.adapters.`in`.controller.response

import br.com.bitencourt.application.core.domain.Person

data class PersonResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val address: AddressResponse,
    val phone: String
) {
    constructor(person: Person): this(
        person.id!!,
        person.firstName,
        person.lastName,
        AddressResponse(person.address!!),
        person.phone
    )
}
