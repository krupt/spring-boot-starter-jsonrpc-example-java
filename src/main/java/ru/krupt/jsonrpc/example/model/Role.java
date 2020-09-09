package ru.krupt.jsonrpc.example.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Role {

    private UUID id;
    private String name;
}
