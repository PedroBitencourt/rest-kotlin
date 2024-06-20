package br.com.bitencourt.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "person")
class Person (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,

              @Column(name = "first_name", nullable = false)
              var firstName: String = "",

              @Column(name = "last_name", nullable = false)
              var lastName: String = "",

              @Column
              var address: String = "",

              @Column
              var phone: String = "")