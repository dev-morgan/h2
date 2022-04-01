package com.sample.h2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.collections.shouldBeEmpty
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
class AddressRepositoryTest(
    val sut: AddressRepository
) : StringSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        "findAll" {
            val actual = sut.findAll()

            actual.shouldBeEmpty()
        }
    }
}
