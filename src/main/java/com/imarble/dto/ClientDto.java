package com.imarble.dto;

import com.imarble.entities.Clients;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Long clientid;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String gstnumber;
    private Clients.ClientType type;
}
