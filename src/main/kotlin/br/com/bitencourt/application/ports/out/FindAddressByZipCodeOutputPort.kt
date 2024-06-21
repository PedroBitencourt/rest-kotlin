package br.com.bitencourt.application.ports.out

import br.com.bitencourt.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipcode: String): Address
}