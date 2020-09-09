package ru.krupt.jsonrpc.example.web.jsonrpc.role;

import com.github.krupt.jsonrpc.JsonRpcMethod;
import ru.krupt.jsonrpc.example.dto.RoleCreateRequest;
import ru.krupt.jsonrpc.example.model.Role;

import java.util.UUID;

public class CreateMethod implements JsonRpcMethod<RoleCreateRequest, Role> {

    @Override
    public Role invoke(RoleCreateRequest input) {
        return Role.builder()
                .id(UUID.randomUUID())
                .name(input.getName())
                .build();
    }
}
