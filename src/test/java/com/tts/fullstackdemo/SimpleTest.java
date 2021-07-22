package com.tts.fullstackdemo;

import com.tts.fullstackdemo.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    Logger log = LoggerFactory.getLogger(SimpleTest.class);

    User user;

    @BeforeEach
    public void setUp() {
        log.info("This log will occur before every test!");
        user = new User(6L, "Samantha");
    }

    @AfterEach
    public void tearDown(){
        log.info("This log will occur after every test!");
        user = new User();
    }

    @Test
    public void simpleTest() {
        // here we have a very basic test
        // i want to test a simple condition
        // by writing an assertion
        log.info(String.valueOf(user));
        assertTrue(true);
    }

    @Test
    public void userTest() {
        var expected = new User(6L, "Samantha");
        var actual = user;

        assertEquals(expected, actual);
    }


}
