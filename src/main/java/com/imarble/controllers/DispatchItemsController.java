package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imarble.dto.DispatchItemsDto;
import com.imarble.entities.DispatchItems;
import com.imarble.services.DispatchItemsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dispatch-items")
public class DispatchItemsController {
    @Autowired
    private DispatchItemsService service;

    // Create Dispatch Item
    @PostMapping("/adddispatchitem")
    public ResponseEntity<DispatchItems> create(@Valid @RequestBody DispatchItemsDto dto) {
        return ResponseEntity.ok(service.createDispatchItem(dto));
    }

    // Get All
    @GetMapping("/alldispatchitems")
    public ResponseEntity<List<DispatchItems>> getAll() {
        return ResponseEntity.ok(service.getAllDispatchItems());
    }

    // Get by Dispatch ID
    @GetMapping("/dispatch/{dispatchId}")
    public ResponseEntity<List<DispatchItems>> getByDispatch(@PathVariable Long dispatchId) {
        return ResponseEntity.ok(service.getDispatchItemsByDispatch(dispatchId));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<DispatchItems> update(@PathVariable Long id,
                                                @Valid @RequestBody DispatchItemsDto dto) {
        return ResponseEntity.ok(service.updateDispatchItem(id, dto));
    }

    // Delete
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteDispatchItem(id);
        return ResponseEntity.ok("Dispatch item deleted successfully");
    }
}
