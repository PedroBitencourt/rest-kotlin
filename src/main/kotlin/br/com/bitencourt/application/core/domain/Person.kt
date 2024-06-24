package br.com.bitencourt.application.core.domain

import jakarta.persistence.*

data class Person (val id: Long? = null,

              val firstName: String,

              val lastName: String,

              var address: Address? = null,

              val phone: String)