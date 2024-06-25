package br.com.bitencourt.application.ports.`in`

import br.com.bitencourt.application.core.domain.Person

interface FindAllPersonInputPort {

    fun find(): List<Person>
}