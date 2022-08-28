plugins {
    id("com.qiusuo.common")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("net.sf.ehcache:ehcache")
    implementation("javax.cache:cache-api")
}