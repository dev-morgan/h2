package com.sample.h2.domain

import javax.persistence.*

@Entity
@Table(name = "addresses")
class Address(
    city: String,
    user: User,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false)
    var city: String = city
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User = user
        private set
}
