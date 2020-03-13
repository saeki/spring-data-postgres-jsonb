package com.example.demo.service

import com.example.demo.data.Person
import com.example.demo.data.PersonRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.annotation.PostConstruct
import javax.transaction.Transactional

@Service
class PersonService(
        private val repository: PersonRepository
) {

    @Transactional
    fun findAll(): List<Person> {
        return repository.findAll()
    }

    @Transactional
    fun save(person: Person): Person {
        return repository.save(person)
    }

    @PostConstruct
    @Transactional
    fun populate() {
        if (repository.count() != 0L) {
            return
        }
        repository.saveAll(listOf(
                Person(
                        id = UUID.randomUUID(),
                        name = "Alice",
                        metadata = Person.Metadata(
                                dob = LocalDate.of(1997, Month.JANUARY, 24),
                                tags = listOf("engineer", "newbie")
                        ),
                        params = listOf(
                                Person.Parameter("city", "San Diego"),
                                Person.Parameter("sport", "Tennis")
                        )
                ),
                Person(
                        id = UUID.randomUUID(),
                        name = "Betty",
                        metadata = Person.Metadata(
                                bloodType = "A+",
                                tags = listOf("scientist")
                        ),
                        params = listOf(
                                Person.Parameter("email", "betty@example.com"),
                                Person.Parameter("city", "San Francisco")
                        )
                )
        ))
    }
}
