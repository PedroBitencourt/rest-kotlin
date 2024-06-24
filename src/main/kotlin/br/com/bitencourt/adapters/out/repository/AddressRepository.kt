package br.com.bitencourt.adapters.out.repository

import br.com.bitencourt.adapters.out.repository.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<AddressEntity, Long> {
}