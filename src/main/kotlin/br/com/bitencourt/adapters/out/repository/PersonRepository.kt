package br.com.bitencourt.adapters.out.repository

import br.com.bitencourt.adapters.out.repository.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long> {
}