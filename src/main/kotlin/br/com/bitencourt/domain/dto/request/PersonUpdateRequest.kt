package br.com.bitencourt.domain.dto.request

data class PersonUpdateRequest(var id: Long,
                               var firstName: String? = null
                               , var lastName: String? = null,
                               var address: String? = null,
                               var phone: String? = null)