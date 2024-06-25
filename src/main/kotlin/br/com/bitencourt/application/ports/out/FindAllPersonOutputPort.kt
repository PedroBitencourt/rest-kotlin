package br.com.bitencourt.application.ports.out

import br.com.bitencourt.application.core.domain.Person

interface FindAllPersonOutputPort {

    fun find(): List<Person>
}