package br.com.bitencourt.adapters.out.repository.entity

import br.com.bitencourt.application.core.domain.Person
import jakarta.persistence.*

@Entity
@Table(name = "person")
data class PersonEntity(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,

                        @Column(name = "first_name", nullable = false)
                        val firstName: String = "",

                        @Column(name = "last_name", nullable = false)
                        val lastName: String = "",

                        @OneToOne(cascade = [CascadeType.ALL])
                        @JoinColumn(name = "address_id", referencedColumnName = "id")
                        val address: AddressEntity? = null,

                        @Column
                        val phone: String = "") {
    constructor(person: Person): this(person.id, person.firstName, person.lastName, AddressEntity(person.address!!), person.phone)

    fun toPerson() = Person(id, firstName, lastName, address?.toAddress(), phone)
}