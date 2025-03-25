plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`
}

group = "drodobyte"
version = "1.0"

dependencies {
    implementation(libs.antlr)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/drodobyte/exp")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITUSERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITTOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
