package br.com.bitencourt.adapters.out.client.response

import br.com.bitencourt.application.core.domain.Address

data class AddressResponse(val street: String, val cep: String, val city: String, val state: String) {
    fun toAddress() = Address(street = street, zipCode = cep, city = city, state = state)
}