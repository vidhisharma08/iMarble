package com.imarble.mapper;

import com.imarble.dto.ClientDto;
import com.imarble.entities.Clients;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto toDto(Clients client) {
        if (client == null) return null;
        return ClientDto.builder()
                .clientid(client.getClientid())
                .name(client.getName())
                .mobile(client.getMobile())
                .email(client.getEmail())
                .address(client.getAddress())
                .gstnumber(client.getGstnumber())
                .type(client.getType())
                .build();
    }

    public Clients toEntity(ClientDto dto) {
        if (dto == null) return null;
        Clients client = new Clients();
        client.setClientid(dto.getClientid());
        client.setName(dto.getName());
        client.setMobile(dto.getMobile());
        client.setEmail(dto.getEmail());
        client.setAddress(dto.getAddress());
        client.setGstnumber(dto.getGstnumber());
        client.setType(dto.getType());
        return client;
    }
}
