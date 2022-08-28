plugins {
    id("com.qiusuo.common")
}

group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":springkafkatutorial:event-core"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:14.0.0")
}
