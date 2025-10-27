package com.imarble.controllers;

import com.imarble.dto.ClientDto;
import com.imarble.dto.ApiResponse;
import com.imarble.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Create Client
    @PostMapping("/addclient")
    public ResponseEntity<ApiResponse<ClientDto>> createClient(@RequestBody ClientDto clientDto) {
        ClientDto created = clientService.createClient(clientDto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Client created successfully", created));
    }

    // Get Client by ID
    @GetMapping("/getclient/{id}")
    public ResponseEntity<ApiResponse<ClientDto>> getClient(@PathVariable Long id) {
        ClientDto dto = clientService.getClientById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Client fetched successfully", dto));
    }

    // Get All Clients
    @GetMapping("/getallclients")
    public ResponseEntity<ApiResponse<List<ClientDto>>> getAllClients() {
        List<ClientDto> list = clientService.getAllClients();
        return ResponseEntity.ok(new ApiResponse<>(true, "Clients fetched successfully", list));
    }

    // Update Client
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ClientDto>> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        ClientDto updated = clientService.updateClient(id, clientDto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Client updated successfully", updated));
    }

    // Delete Client
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Client deleted successfully", null));
    }
}
