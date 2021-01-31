plugins {
    id 'java'
    id 'org.jetbrains.kotlin.jvm' version '1.4.21'
}

group 'com.qiusuo'
version '0.0.1-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testCompile("junit:junit:4.12")
}
