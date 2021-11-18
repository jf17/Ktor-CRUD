import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val exposedVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.0"
}

group = "ru.jf17"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenLocal()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-gson:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}