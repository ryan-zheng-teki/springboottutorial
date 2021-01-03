plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testCompile("junit:junit:4.12")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    runtimeOnly("com.h2database:h2")
    implementation("io.r2dbc:r2dbc-h2")
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
    }
    testImplementation("io.projectreactor:reactor-test")
}
