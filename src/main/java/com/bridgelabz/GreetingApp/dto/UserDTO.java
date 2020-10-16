package com.bridgelabz.GreetingApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String message;
}
