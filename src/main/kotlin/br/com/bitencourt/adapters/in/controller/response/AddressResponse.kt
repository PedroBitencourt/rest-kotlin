package br.com.bitencourt.adapters.`in`.controller.response

import br.com.bitencourt.application.core.domain.Address

data class AddressResponse(val street: String,
                           val cep: String,
                           val city: String,
                           val state: String,
                           val neighborhood: String) {
    constructor(address: Address): this(
        address.street,
        address.zipCode,
        address.neighborhood,
        address.state,
        address.city
    )
}
