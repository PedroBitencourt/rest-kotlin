package br.com.bitencourt.application.core.domain

data class Address(
    val id: Long? = null,
    val neighborhood: String,
    val street: String,
    val zipCode: String,
    val city: String,
    val state: String
)
