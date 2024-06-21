package br.com.bitencourt.application.ports.out

import br.com.bitencourt.application.core.domain.Person

interface InsertPersonOutPutPort {

    fun insert(person: Person)
}