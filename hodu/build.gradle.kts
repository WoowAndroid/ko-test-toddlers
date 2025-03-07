plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.10.2")
    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.27.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}