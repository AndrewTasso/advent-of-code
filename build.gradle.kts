plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "one.util", name = "streamex", version = "0.8.0")
}


tasks {
    wrapper {
        gradleVersion = "7.3"
    }
}
