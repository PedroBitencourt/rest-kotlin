package br.com.bitencourt.application.ports.out

import br.com.bitencourt.application.core.domain.Person

interface FindPersonByIdOutputPort {

    fun find(id: Long): Person?
}