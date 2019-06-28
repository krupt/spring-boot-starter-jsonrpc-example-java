package ru.krupt.jsonrpc.example.service;

import com.github.krupt.jsonrpc.annotation.JsonRpcService;
import com.github.krupt.jsonrpc.annotation.NoJsonRpcMethod;
import ru.krupt.jsonrpc.example.dto.UserCreateRequest;
import ru.krupt.jsonrpc.example.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@JsonRpcService
public class UserService {

    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    public User get(UUID userId) {
        final User user = users.get(userId);
        if (user != null) {
            return user;
        } else {
            return User.builder()
                    .id(userId)
                    .username("krupt")
                    .firstName("Andrey")
                    .lastName("Kovalev")
                    .build();
        }
    }

    public User create(UserCreateRequest createRequest) {
        final User user = User.builder()
                .id(UUID.randomUUID())
                .username(createRequest.getUsername())
                .firstName(createRequest.getFirstName())
                .lastName(createRequest.getLastName())
                .build();

        users.put(user.getId(), user);

        return user;
    }

    public List<User> list(int count) {
        return users.values().stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    @NoJsonRpcMethod
    public List<User> createUsers(List<UserCreateRequest> users) {
        return Collections.emptyList();
    }
}
