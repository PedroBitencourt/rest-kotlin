package br.com.bitencourt.adapters.`in`.controller.request
import jakarta.validation.constraints.NotBlank

data class PersonRequest (
    @field:NotBlank(message = "First name must not be blank")
    val firstName: String,
    @field:NotBlank(message = "Last name must not be blank")
    val lastName: String,
    @field:NotBlank(message = "Zip code must not be blank")
    val zipCode: String,
    @field:NotBlank(message = "Phone name must not be blank")
    val phone: String)