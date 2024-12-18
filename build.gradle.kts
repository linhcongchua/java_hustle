plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.postgresql:postgresql:42.2.1")
    implementation("com.zaxxer:HikariCP:6.2.1")
    implementation("com.github.javafaker:javafaker:1.0.2")
    compileOnly("org.projectlombok:lombok:1.18.32")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}