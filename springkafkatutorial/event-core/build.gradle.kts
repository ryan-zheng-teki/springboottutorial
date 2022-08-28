plugins {
    id("com.qiusuo.common")
}


group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    api("io.projectreactor.kafka:reactor-kafka:1.1.0.RELEASE")
    api("org.springframework.kafka:spring-kafka")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}