package com.bridgelabz.GreetingApp.service;


import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.dto.UserDTO;
import com.bridgelabz.GreetingApp.exception.GreetingMessageException;
import com.bridgelabz.GreetingApp.modle.GreetingMessage;
import com.bridgelabz.GreetingApp.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GreetingService implements IGreetingService{

    @Autowired
    IGreetingRepository greetingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String createMessage(UserDTO userDTO) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingMessage(this.getMessage(userDTO.getMessage(),
                userDTO.getFirstName(), userDTO.getLastName()));
        greetingRepository.save(greetingMessage);
        return "Message Successfully Saved";
    }

    public String getMessage(String message, String firstName, String lastName) {
        if (message != null && message.length() != 0)
            return message;
        if ((firstName != null && firstName.length() != 0) && (lastName != null && lastName.length() != 0))
           return "Hello "+ firstName + " "+ lastName;
        if (firstName != null && firstName.length() != 0)
            return "Hello "+ firstName ;
        if (lastName != null && lastName.length() != 0)
            return "Hello "+ lastName;
        return "Hello World";
    }

    @Override
    public GreetingMessage findMessageById(Long id) {
        return greetingRepository.findById(id).orElseThrow(
                () -> new GreetingMessageException("Record not found"));
    }

    @Override
    public List<GreetingMessage> findAllMessage() {
        return greetingRepository.findAll();
    }

    @Override
    public String updateMessage(GreetingDTO greetingDTO) {
        findMessageById(greetingDTO.getGreetingId());
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setGreetingId(greetingDTO.getGreetingId());
        greetingMessage.setGreetingMessage( getMessage( greetingDTO.getMessage(),
                greetingDTO.getFirstName(), greetingDTO.getLastName()));
        greetingRepository.save(greetingMessage);
        return "Message Successfully Updated";
    }

    @Override
    public String deleteMessage(Long id) {
        greetingRepository.delete(findMessageById(id));
        return "Successfully deleted";
    }
}
