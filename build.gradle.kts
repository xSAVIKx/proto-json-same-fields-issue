plugins {
    java
    id("io.spine.tools.gradle.bootstrap").version("1.5.23")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

spine {
    enableJava().server()
}

dependencies {
    implementation("com.google.api.grpc:proto-google-cloud-pubsub-v1:1.89.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "com.github.proto.TestDeserialization"
}

defaultTasks("run")
