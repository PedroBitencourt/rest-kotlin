package br.com.bitencourt.adapters.out.repository.entity

import br.com.bitencourt.application.core.domain.Address
import br.com.bitencourt.application.core.domain.Person
import jakarta.persistence.*

@Entity
@Table(name = "address")
data class AddressEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,
    @Column
    val street: String = "",
    @Column
    val zipcode: String = "",
    @Column
    val neighborhood: String = "",
    @Column
    val city: String = "",
    @Column
    val state: String = "",
    ) {

    constructor(address: Address) : this(address.id, address.street, address.zipCode, address.neighborhood, address.city, address.state)

    fun toAddress() =  Address(id, street, zipcode, neighborhood, city, state)

}