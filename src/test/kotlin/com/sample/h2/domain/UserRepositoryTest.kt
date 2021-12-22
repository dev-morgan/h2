package com.sample.h2.domain

import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.spring.SpringListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest : StringSpec() {
    override fun listeners(): List<TestListener> = listOf(SpringListener)

    @Autowired
    lateinit var sut: UserRepository

    init {
        "findAll" {
            val actual = sut.findAll()

            actual.shouldBeEmpty()
        }
    }
}
