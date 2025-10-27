package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.StaffDto;
import com.imarble.dto.ApiResponse;
import com.imarble.entities.Staff;
import com.imarble.services.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Create Staff
    @PostMapping("/addstaff")
    public ResponseEntity<ApiResponse<Staff>> createStaff(@Valid @RequestBody StaffDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Staff created successfully", staffService.createStaff(dto))
        );
    }

    // Get All Staff
    @GetMapping("/allstaff")
    public ResponseEntity<ApiResponse<List<Staff>>> getAllStaff() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All staff records fetched successfully", staffService.getAllStaff())
        );
    }

    // Get Staff By ID
    @GetMapping("/getstaff/{id}")
    public ResponseEntity<ApiResponse<Staff>> getStaff(@PathVariable Long id) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Staff fetched successfully", staffService.getStaffById(id))
        );
    }

    // Update Staff
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Staff>> updateStaff(@PathVariable Long id, @Valid @RequestBody StaffDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Staff updated successfully", staffService.updateStaff(id, dto))
        );
    }

    // Delete Staff
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Staff deleted successfully", null)
        );
    }
}
