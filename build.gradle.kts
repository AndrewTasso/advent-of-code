plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect")

    testImplementation(kotlin("test"))
    testImplementation("io.kotest", "kotest-runner-junit5", "5.5.4")
}

tasks {
    wrapper {
        gradleVersion = "7.6"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}
