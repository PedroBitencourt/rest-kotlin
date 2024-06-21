package br.com.bitencourt.utils

import br.com.bitencourt.application.core.domain.Person

class PersonUtils {

    companion object {
        fun person1() = Person(1L, "John", "Doe", "123 Main St", "555-1234")
        fun person2() = Person(2L, "Jane", "Smith", "456 Elm St", "555-5678")
        fun listOfPerson() = listOf(person1(), person2())
    }
}