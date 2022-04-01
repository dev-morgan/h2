package com.sample.h2.domain

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    username: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false)
    var username: String = username
        private set
}
