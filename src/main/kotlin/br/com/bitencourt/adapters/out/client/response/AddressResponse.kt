package br.com.bitencourt.adapters.out.client.response

import br.com.bitencourt.application.core.domain.Address

data class AddressResponse(val street: String, val zipCode: String, val city: String, val state: String) {
    fun toAddress() = Address(street = street, zipCode = zipCode, city = city, state = state)
}