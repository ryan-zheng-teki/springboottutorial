plugins {
    id("com.qiusuo.common")
}

dependencies {
    implementation(project(":springkafkatutorial:event-core"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:14.0.0")
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.data:spring-data-r2dbc")
}
