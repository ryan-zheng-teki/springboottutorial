package com.qiusuo.springbootrabbitmq;


import com.qiusuo.springbootrabbitmq.message.Receiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRabbitmqTutorial.class)
public class TestSendMessge {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;

    @Test
    public void testSendMessagte() {
        rabbitTemplate.convertAndSend("spring-boot-rabbitmq", "foo.bar.baz", "Hello from RabbitMQ!");
    }
}
