package br.com.bitencourt.application.ports.out

import br.com.bitencourt.application.core.domain.Person

interface InsertPersonOutputPort {

    fun insert(person: Person)
}