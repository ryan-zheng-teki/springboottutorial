plugins {
    id("com.qiusuo.common")
}


repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(project(":springkafkatutorial:event-core"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.experimental:graphql-spring-boot-starter:1.0.0-M4")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.data:spring-data-r2dbc")
    implementation("io.r2dbc:r2dbc-h2:1.0.0.RC1")
    implementation("com.h2database:h2:2.1.214")
}
