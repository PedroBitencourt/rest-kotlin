package br.com.bitencourt.adapters.out

import br.com.bitencourt.adapters.out.repository.PersonRepository
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.application.ports.out.FindPersonByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindPersonByIdAdapter(private val personRepository: PersonRepository): FindPersonByIdOutputPort {
    override fun find(id: Long): Person? {
        return personRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toPerson()
            }
    }
}