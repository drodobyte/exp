plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.drodobyte"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(libs.drodobyte.core)
    implementation(libs.bundles.rx)
    implementation(libs.antlr)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}
