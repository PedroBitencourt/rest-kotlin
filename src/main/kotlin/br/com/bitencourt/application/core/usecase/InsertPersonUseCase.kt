package br.com.bitencourt.application.core.usecase

import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.out.FindAddressByZipCodeOutputPort
import br.com.bitencourt.application.ports.out.InsertPersonOutPutPort

class InsertPersonUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertPersonOutPutPort: InsertPersonOutPutPort
) {

    fun insert(person: Person, zipCode: String) {
        person.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertPersonOutPutPort.insert(it)
        }
    }
}