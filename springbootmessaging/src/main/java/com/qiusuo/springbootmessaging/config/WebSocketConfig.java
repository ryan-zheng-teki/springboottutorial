package com.qiusuo.springbootmessaging.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.Session;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.session.web.socket.server.SessionRepositoryMessageInterceptor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSessionWebSocketMessageBrokerConfigurer<Session> {
    @Autowired
    private HttpHandshakeInterceptor handshakeInterceptor;

    @Autowired
    private SessionRepositoryMessageInterceptor sessionRepositoryMessageInterceptor;

    @Value("${qiusuo.relay.host}")
    private String relayHost;

    @Value("${qiusuo.relay.port}")
    private Integer relayPort;

    @Override
    protected void configureStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS().setInterceptors(handshakeInterceptor,sessionRepositoryMessageInterceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/queue/", "/topic/")
                .setRelayHost(relayHost)
                .setRelayPort(relayPort);
        registry.setApplicationDestinationPrefixes("/app");
    }

}
