plugins {
    java
}

repositories {
    mavenCentral()
}

val lombokVersion = "1.18.12"

dependencies {
    // Lombok
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-webflux:8.1.0")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-tools:8.1.0")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:8.1.0")
// https://mvnrepository.com/artifact/io.projectreactor/reactor-core
    implementation("io.projectreactor:reactor-core:3.4.1")
    implementation("io.r2dbc:r2dbc-postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("junit:junit:4.12")
}
