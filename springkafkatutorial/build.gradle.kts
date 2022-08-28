plugins {
    id("com.qiusuo.common")
}


tasks.register<Exec>("setUpKafka") {
    val downloadKafkaDockerCompose = "curl --silent --output docker-compose.yml \\\n" +
            "https://raw.githubusercontent.com/confluentinc/cp-all-in-one/7.2.1-post/cp-all-in-one/docker-compose.yml\n" +
            "\n" +
            "docker-compose up -d\n"
    commandLine(downloadKafkaDockerCompose)
}
