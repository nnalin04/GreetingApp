package com.bridgelabz.GreetingApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TypeDefs;

@Getter
@Setter
@ToString
public class GreetingDTO {
    private Long greetingId;
    private String firstName;
    private String lastName;
    private String message;
}
