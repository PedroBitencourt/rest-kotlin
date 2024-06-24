package br.com.bitencourt.application.ports.`in`

import br.com.bitencourt.application.core.domain.Person

interface FindPersonByIdInputPort {

    fun find(id: Long): Person
}