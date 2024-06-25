package br.com.bitencourt.application.core.usecase

import br.com.bitencourt.application.ports.`in`.FindAllPersonInputPort
import br.com.bitencourt.application.ports.out.FindAllPersonOutputPort

class FindAllPersonUseCase(
    private val findAllPersonOutputPort: FindAllPersonOutputPort
): FindAllPersonInputPort {

    override fun find() = findAllPersonOutputPort.find()
}