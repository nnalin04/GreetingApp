package com.bridgelabz.GreetingApp.modle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class GreetingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long greetingId;

    private String greetingMessage;
}
