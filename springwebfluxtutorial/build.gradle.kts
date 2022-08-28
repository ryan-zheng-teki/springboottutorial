plugins {
    id("com.qiusuo.common")
    kotlin("plugin.allopen") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}


dependencies {
    compileOnly("org.projectlombok:lombok:${project.properties["lombokVersion"]}")
    annotationProcessor("org.projectlombok:lombok:${project.properties["lombokVersion"]}")
    implementation("org.projectlombok:lombok:${project.properties["lombokVersion"]}")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-tools:${project.properties["LIB_GRAPHQL_SPRING_BOOT_VER"]}")
    implementation("com.graphql-java-kickstart:graphql-kickstart-spring-boot-starter-webflux:${project.properties["LIB_GRAPHQL_SPRING_BOOT_VER"]}")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:${project.properties["LIB_GRAPHQL_SPRING_BOOT_VER"]}")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")

    implementation("io.projectreactor:reactor-core:3.4.1")
    implementation("io.projectreactor:reactor-tools")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.r2dbc:r2dbc-postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("junit:junit:4.12")
}
