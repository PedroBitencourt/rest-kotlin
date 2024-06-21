package br.com.bitencourt.adapters.out.client.response

data class AddressResponse(
    val street: String,
    val zipCode: String,
    val city: String,
    val state: String
)
