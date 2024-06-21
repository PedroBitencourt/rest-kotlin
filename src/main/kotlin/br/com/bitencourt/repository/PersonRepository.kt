package br.com.bitencourt.repository

import br.com.bitencourt.application.core.domain.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>{
}