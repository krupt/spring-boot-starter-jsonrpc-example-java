package ru.krupt.jsonrpc.example.dto;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String username;
    private String firstName;
    private String lastName;
}
