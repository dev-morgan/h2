import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    val kotlinVersion = "1.6.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    id("org.springframework.boot") version "2.6.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

java.sourceCompatibility = JavaVersion.VERSION_11

val bootJar: BootJar by tasks
bootJar.enabled = false

group = "com.sample.h2"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val h2Version = "h2:2.0.206"
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:$h2Version")
    testImplementation("io.kotest:kotest-runner-junit5:5.2.2")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
