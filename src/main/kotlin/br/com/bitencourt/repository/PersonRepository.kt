package br.com.bitencourt.repository

import br.com.bitencourt.domain.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>{
}