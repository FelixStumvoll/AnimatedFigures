plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

tasks.withType<JavaCompile> {
    sourceCompatibility = "15"
    targetCompatibility = "15"
}

application {
    mainClass.set("animatedfigures.App")
}

repositories {
    mavenCentral()
}

