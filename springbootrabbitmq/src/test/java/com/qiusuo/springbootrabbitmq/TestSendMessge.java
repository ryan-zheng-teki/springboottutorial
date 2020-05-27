package com.qiusuo.springbootrabbitmq;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSendMessge {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessagte() {
        rabbitTemplate.convertAndSend("spring-boot-rabbitmq", "foo.bar.baz", "Hello from RabbitMQ!");
    }
}
