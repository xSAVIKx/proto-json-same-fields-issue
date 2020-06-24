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
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClassName = "com.github.proto.TestDeserialization"
}

defaultTasks("run")
