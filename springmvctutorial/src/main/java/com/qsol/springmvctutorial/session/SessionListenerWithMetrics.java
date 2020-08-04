package com.qsol.springmvctutorial.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionListenerWithMetrics implements HttpSessionListener {
    private final AtomicInteger activeSessions;

    public SessionListenerWithMetrics() {
        super();
        activeSessions = new AtomicInteger(0);
    }

    public int getTotalActiveSessions() {
        return activeSessions.get();
    }

    public void  sessionCreated(HttpSessionEvent event) {
        activeSessions.incrementAndGet();
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions.decrementAndGet();
        System.out.println("session destroyed");
    }
}
