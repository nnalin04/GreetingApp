package com.bridgelabz.GreetingApp;

import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.dto.UserDTO;
import com.bridgelabz.GreetingApp.exception.GreetingMessageException;
import com.bridgelabz.GreetingApp.modle.GreetingMessage;
import com.bridgelabz.GreetingApp.repository.IGreetingRepository;
import com.bridgelabz.GreetingApp.service.GreetingService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GreetingServiceTest {

    @Mock
    IGreetingRepository greetingRepository;

    @InjectMocks
    GreetingService service;

    @Test
    public void demoTest() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void givenUserDTO_WhenSaved_ShouldReturnSuccessFull() {
        GreetingMessage greetingMessage = new GreetingMessage();
        when(greetingRepository.save(greetingMessage)).thenReturn(greetingMessage);
        String message = service.createMessage(new UserDTO());
        Assertions.assertEquals("Message Successfully Saved", message);
    }

    @Test
    public void givenEditedData_WhenUpdated_ShouldReturnSuccessFull() {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingId(123L);
        GreetingDTO greetingDTO = new GreetingDTO();
        greetingDTO.setGreetingId(123L);
        when(greetingRepository.save(greetingMessage)).thenReturn(greetingMessage);
        when(greetingRepository.findById(anyLong())).thenReturn(java.util.Optional.of(greetingMessage));
        String message = service.updateMessage(greetingDTO);
        Assertions.assertEquals("Message Successfully Updated", message);
    }
}
