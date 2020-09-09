package ru.krupt.jsonrpc.example.web.jsonrpc.role;

import com.github.krupt.jsonrpc.JsonRpcMethod;

import java.util.UUID;

public class DeleteMethod implements JsonRpcMethod<UUID, Void> {

    @Override
    public Void invoke(UUID input) {
        // Some delete operation here :)
        return null;
    }
}
