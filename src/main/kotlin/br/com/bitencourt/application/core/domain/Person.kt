package br.com.bitencourt.application.core.domain

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,

              @Column(name = "first_name", nullable = false)
              var firstName: String = "",

              @Column(name = "last_name", nullable = false)
              var lastName: String = "",

              @Column
              var address: Address,

              @Column
              var phone: String = "")