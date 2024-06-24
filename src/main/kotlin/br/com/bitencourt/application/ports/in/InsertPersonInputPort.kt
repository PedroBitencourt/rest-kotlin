package br.com.bitencourt.application.ports.`in`

import br.com.bitencourt.application.core.domain.Person

interface InsertPersonInputPort {

    fun insert(person: Person, zipCode: String)
}