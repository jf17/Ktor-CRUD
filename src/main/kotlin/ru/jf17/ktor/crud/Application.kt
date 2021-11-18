package ru.jf17.ktor.crud

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import ru.jf17.ktor.crud.models.Customer
import ru.jf17.ktor.crud.models.customerStorage
import ru.jf17.ktor.crud.routes.registerCustomerRoutes

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    customerStorage.add(Customer("1","Alex","jf17","alex@jf17.ru"))
    customerStorage.add(Customer("2","Max","jf17","max@jf17.ru"))

    registerCustomerRoutes()
}