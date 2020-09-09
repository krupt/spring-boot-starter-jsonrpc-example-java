package ru.krupt.jsonrpc.example.web.jsonrpc.role;

import com.github.krupt.jsonrpc.JsonRpcMethod;
import ru.krupt.jsonrpc.example.model.Role;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class GetAllMethod implements JsonRpcMethod<Void, List<Role>> {

    @Override
    public List<Role> invoke(Void input) {
        return Collections.singletonList(
                Role.builder()
                        .id(UUID.randomUUID())
                        .name("admin")
                        .build()
        );
    }
}
