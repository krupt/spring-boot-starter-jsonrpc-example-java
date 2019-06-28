package ru.krupt.jsonrpc.example.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.krupt.jsonrpc.example.dto.UserCreateRequest;
import ru.krupt.jsonrpc.example.model.User;
import ru.krupt.jsonrpc.example.service.UserService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public List<User> loadUsersFromFile(@RequestParam MultipartFile file) {
        // parse file and store users to users variable
        final List<UserCreateRequest> users = Collections.emptyList();

        return userService.createUsers(users);
    }
}
