package br.com.bitencourt.adapters.out

import br.com.bitencourt.adapters.out.client.FindAddressByZipCodeClient
import br.com.bitencourt.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(private val findAddressByZipCodeClient: FindAddressByZipCodeClient): FindAddressByZipCodeOutputPort {

    override fun find(zipcode: String) = findAddressByZipCodeClient.find(zipcode).toAddress()

}