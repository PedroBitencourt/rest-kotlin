package br.com.bitencourt.domain.dto.request

import br.com.bitencourt.application.core.domain.Person

data class PersonCreateRequest (var firstName: String, var lastName: String, var address: String, var phone: String) {
    fun toPerson() = Person(
        firstName = this.firstName,
        lastName = this.lastName,
        address = this.address,
        phone = this.phone
    )
}


