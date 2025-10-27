package com.imarble.services;

import com.imarble.dto.ClientDto;
import com.imarble.entities.Clients;
import com.imarble.mapper.ClientMapper;
import com.imarble.repos.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService{ 

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

 
    public ClientDto createClient(ClientDto clientDto) {
        Clients client = clientMapper.toEntity(clientDto);
        Clients saved = clientRepository.save(client);
        return clientMapper.toDto(saved);
    }

    
    public ClientDto getClientById(Long clientId) {
        Clients client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        return clientMapper.toDto(client);
    }

   
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

  
    public ClientDto updateClient(Long clientId, ClientDto clientDto) {
        Clients client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        client.setName(clientDto.getName());
        client.setMobile(clientDto.getMobile());
        client.setEmail(clientDto.getEmail());
        client.setAddress(clientDto.getAddress());
        client.setGstnumber(clientDto.getGstnumber());
        client.setType(clientDto.getType());
        Clients updated = clientRepository.save(client);
        return clientMapper.toDto(updated);
    }

    
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
