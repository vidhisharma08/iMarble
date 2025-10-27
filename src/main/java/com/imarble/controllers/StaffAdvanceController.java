package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.StaffAdvanceDto;
import com.imarble.dto.ApiResponse;
import com.imarble.entities.StaffAdvance;
import com.imarble.services.StaffAdvanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staff-advance")
public class StaffAdvanceController {
    
    @Autowired
    private StaffAdvanceService advanceService;

    // Create advance
    @PostMapping("/addadvance")
    public ResponseEntity<ApiResponse<StaffAdvance>> createAdvance(@Valid @RequestBody StaffAdvanceDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Advance created successfully", advanceService.createAdvance(dto))
        );
    }

    // Get all advances
    @GetMapping("/alladvance")
    public ResponseEntity<ApiResponse<List<StaffAdvance>>> getAllAdvances() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All advances fetched successfully", advanceService.getAllAdvances())
        );
    }

    // Get advances by staff
    @GetMapping("/getadvance/{staffId}")
    public ResponseEntity<ApiResponse<List<StaffAdvance>>> getAdvancesByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Advances fetched successfully for staff ID: " + staffId, advanceService.getAdvancesByStaff(staffId))
        );
    }

    // Update advance
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<StaffAdvance>> updateAdvance(@PathVariable Long id, @Valid @RequestBody StaffAdvanceDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Advance updated successfully", advanceService.updateAdvance(id, dto))
        );
    }

    // Delete advance
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAdvance(@PathVariable Long id) {
        advanceService.deleteAdvance(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Advance record deleted successfully", null)
        );
    }
}
