package com.bridgelabz.GreetingApp.controller;


import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.dto.UserDTO;
import com.bridgelabz.GreetingApp.modle.GreetingMessage;
import com.bridgelabz.GreetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/Greeting")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @PostMapping
    public ResponseEntity createMessage(@RequestBody UserDTO userDTO) {
        System.out.println("request body"+ userDTO);
        String message = greetingService.createMessage(userDTO);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity getMessageById(@RequestParam Long id) {
        GreetingMessage greetingMessage = greetingService.findMessageById(id);
        return new ResponseEntity(greetingMessage.getGreetingMessage(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllMessage() {
        List<GreetingMessage> greetingMessages = greetingService.findAllMessage();
        return new ResponseEntity<>(greetingMessages, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updateMessageById(@RequestBody GreetingDTO greetingDTO) {
        System.out.println(greetingDTO);
        String greetingMessage = greetingService.updateMessage(greetingDTO);
        return new ResponseEntity(greetingMessage, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteMessageById(@RequestParam Long id) {
        String message = greetingService.deleteMessage(id);
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
