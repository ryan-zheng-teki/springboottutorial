plugins {
    java
    kotlin("jvm")
    id("com.qiusuo.common")
}

group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"
val LIB_GRAPHQL_SPRING_BOOT_VER = "11.0.0"


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit", "junit", "4.12")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-tools:$LIB_GRAPHQL_SPRING_BOOT_VER")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-webflux:$LIB_GRAPHQL_SPRING_BOOT_VER")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:${LIB_GRAPHQL_SPRING_BOOT_VER}")
}
