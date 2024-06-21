package br.com.bitencourt.service


import br.com.bitencourt.domain.dto.request.PersonCreateRequest
import br.com.bitencourt.domain.dto.request.PersonUpdateRequest
import br.com.bitencourt.application.core.domain.Person
import br.com.bitencourt.exception.ResourceNotFoundException
import br.com.bitencourt.repository.PersonRepository
import br.com.bitencourt.utils.PersonUtils.Companion.listOfPerson
import br.com.bitencourt.utils.PersonUtils.Companion.person1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {

    @Mock
    private lateinit var personRepository: PersonRepository

    @InjectMocks
    private lateinit var personService: PersonService

    @Captor
    private lateinit var captor: ArgumentCaptor<Person>

    @Test
    fun testFindAll() {
        `when`(personRepository.findAll()).thenReturn(listOfPerson())

        val result = personService.findAll()

        assertEquals(2, result.size)
        assertEquals(listOfPerson()[0].firstName, result[0].firstName)
        assertEquals(listOfPerson()[1].phone, result[1].phone)
    }

    @Test
    fun testFindById() {
        `when`(personRepository.findById(1L)).thenReturn(Optional.of(person1()))

        val resultFound = personService.findById(1L)

        assertNotNull(resultFound)
        assertEquals(person1().firstName, resultFound.firstName)
    }

    @Test
    fun testFindByIdWhenPersonNotFound() {
        assertThrows(ResourceNotFoundException::class.java) { personService.findById(1L) }
    }

    @Test
    fun testCreatePerson() {
        val request = PersonCreateRequest("John", "Doe", "123 Main St", "555-1234")

        `when`(personRepository.save(any(Person::class.java))).thenReturn(person1())

        val result = personService.createPerson(request)
        verify(personRepository, times(1)).save(captor.capture())

        assertNotNull(result)
        assertEquals(request.firstName, captor.value.firstName)
        assertEquals(request.phone, captor.value.phone)
    }

    @Test
    fun testDeletePerson() {
        personService.deletePerson(1L)

        verify(personRepository, times(1)).deleteById(anyLong())
    }

    @Test
    fun testUpdatePerson() {
        val request = PersonUpdateRequest(1L, firstName = "Jane", phone = "555-5678")
        val existingPerson = Person(1L, "John", "Doe", "123 Main St", "555-1234")
        val updatedPerson = Person(1L, request.firstName!!, existingPerson.lastName, existingPerson.address, request.phone!!)

        `when`(personRepository.findById(1L)).thenReturn(Optional.of(person1()))
        `when`(personRepository.save(any(Person::class.java))).thenReturn(updatedPerson)


        personService.updatePerson(request)

        verify(personRepository, times(1)).save(captor.capture())

        assertEquals(request.firstName, captor.value.firstName)
        assertEquals(request.phone, captor.value.phone)
    }
}
