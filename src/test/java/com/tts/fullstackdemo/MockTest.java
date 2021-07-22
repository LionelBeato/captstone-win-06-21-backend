package com.tts.fullstackdemo;

import com.tts.fullstackdemo.model.User;
import com.tts.fullstackdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MockTest {

    @MockBean
    UserService userService;

    @Test
    public void mockTest() {
        // here we set up a user as our expected value
        User expected = new User(3L, "Bobby");
        // here we ensure that when the method below is called
        // we get the expected value, thus guaranteeing behavior
        Mockito.when(userService.createModel(expected))
                .thenReturn(expected);

        var actual = userService.createModel(new User(3L, "Bobby"));

        assertEquals(expected, actual);

        Mockito.verify(userService).createModel(new User(3L, "Bobby"));
    }

}
