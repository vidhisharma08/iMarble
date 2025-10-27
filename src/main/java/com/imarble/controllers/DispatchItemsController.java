package com.imarble.controllers;

import com.imarble.dto.DispatchItemsDto;
import com.imarble.dto.ApiResponse;
import com.imarble.entities.DispatchItems;
import com.imarble.services.DispatchItemsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispatch-items")
public class DispatchItemsController {

    @Autowired
    private DispatchItemsService service;

    // Create Dispatch Item
    @PostMapping("/adddispatchitem")
    public ResponseEntity<ApiResponse<DispatchItems>> create(@Valid @RequestBody DispatchItemsDto dto) {
        DispatchItems created = service.createDispatchItem(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Dispatch item created successfully", created));
    }

    // Get All
    @GetMapping("/alldispatchitems")
    public ResponseEntity<ApiResponse<List<DispatchItems>>> getAll() {
        List<DispatchItems> list = service.getAllDispatchItems();
        return ResponseEntity.ok(new ApiResponse<>(true, "All dispatch items fetched successfully", list));
    }

    // Get by Dispatch ID
    @GetMapping("/dispatch/{dispatchId}")
    public ResponseEntity<ApiResponse<List<DispatchItems>>> getByDispatch(@PathVariable Long dispatchId) {
        List<DispatchItems> list = service.getDispatchItemsByDispatch(dispatchId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Dispatch items fetched successfully", list));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<DispatchItems>> update(@PathVariable Long id,
                                                             @Valid @RequestBody DispatchItemsDto dto) {
        DispatchItems updated = service.updateDispatchItem(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Dispatch item updated successfully", updated));
    }

    // Delete
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.deleteDispatchItem(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Dispatch item deleted successfully", null));
    }
}
