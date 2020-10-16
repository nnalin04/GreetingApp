package com.bridgelabz.GreetingApp.service;



import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.dto.UserDTO;
import com.bridgelabz.GreetingApp.modle.GreetingMessage;

import java.util.List;

public interface IGreetingService {
    public String createMessage(UserDTO userDTO);
    public GreetingMessage findMessageById(Long id);
    public List<GreetingMessage> findAllMessage();
    public String updateMessage(GreetingDTO greetingDTO);
    public String deleteMessage(Long id);
}
