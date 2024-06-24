package br.com.bitencourt.application.core.usecase

import br.com.bitencourt.application.core.exception.ResourceNotFoundException
import br.com.bitencourt.application.ports.`in`.FindPersonByIdInputPort
import br.com.bitencourt.application.ports.out.FindPersonByIdOutputPort

class FindPersonByIdUseCase(
    private val findPersonByIdOutputPort: FindPersonByIdOutputPort
): FindPersonByIdInputPort {

    override fun find(id: Long) =
         findPersonByIdOutputPort.find(id) ?: throw ResourceNotFoundException("Person not found")

}