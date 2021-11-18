package ru.jf17.ktor.crud.models

import io.ktor.application.*
import io.ktor.request.*
import kotlinx.serialization.Serializable


@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)


val customerStorage = mutableListOf<Customer>()

