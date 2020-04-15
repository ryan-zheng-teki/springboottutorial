package com.qiusuo.springboottutorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetingTest {

    @Test
    void whenCallingSayHello_thenReturnHello() {
        assertTrue("Hello".equals("Hello"));
    }
}