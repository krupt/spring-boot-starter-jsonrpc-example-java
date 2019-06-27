package ru.krupt.jsonrpc.example.service;

import com.github.krupt.jsonrpc.annotation.NoJsonRpcMethod;
import ru.krupt.jsonrpc.example.dto.UserCreateRequest;
import ru.krupt.jsonrpc.example.model.User;
import com.github.krupt.jsonrpc.annotation.JsonRpcService;

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
            final User defaultUser = new User();
            defaultUser.setId(userId);
            defaultUser.setUsername("krupt");
            defaultUser.setFirstName("Andrey");
            defaultUser.setLastName("Kovalev");

            return defaultUser;
        }
    }

    public User create(UserCreateRequest createRequest) {
        final User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(createRequest.getUsername());
        user.setFirstName(createRequest.getFirstName());
        user.setLastName(createRequest.getLastName());

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
