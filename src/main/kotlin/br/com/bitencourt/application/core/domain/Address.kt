package br.com.bitencourt.application.core.domain

data class Address(
    val id: Long? = null,
    val street: String,
    val zipCode: String,
    val city: String,
    val state: String,
    val personId: Person? = null
)
