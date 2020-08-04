package com.qsol.springmvctutorial.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Order(-1)
public class SessionExpire implements Filter {
    @Override
    public void doFilter(ServletRequest request,
    ServletResponse response,
    FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession();
        int timeout = session.getMaxInactiveInterval();
        session.setMaxInactiveInterval(10);
        long lastAccessTime = session.getLastAccessedTime();
        System.out.println("hello world");
        chain.doFilter(request, response);
    }
}
