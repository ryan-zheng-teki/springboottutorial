plugins {
    id("com.qiusuo.common")
}

group = "com.qiusuo"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.2.41")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}