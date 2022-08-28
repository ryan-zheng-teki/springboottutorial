plugins {
    id("com.qiusuo.common")
    //id("org.springframework.boot") version "2.7.0-RC1"
    //id("org.springframework.experimental.aot") version "0.12.0-SNAPSHOT"
}


group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

