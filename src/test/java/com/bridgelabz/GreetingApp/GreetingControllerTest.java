package com.bridgelabz.GreetingApp;

import com.bridgelabz.GreetingApp.modle.GreetingMessage;
import com.bridgelabz.GreetingApp.service.IGreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IGreetingService service;

    @Test
    public void demoTest() throws Exception {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage("Hello World");
        when(service.findMessageById(123L)).thenReturn(greetingMessage);
        MvcResult mvcResult = mockMvc.perform(get("/Greeting/id?id=123")).andReturn();
        Assertions.assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}
