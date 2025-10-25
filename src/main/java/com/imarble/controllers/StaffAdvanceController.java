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

import com.imarble.dto.StaffAdvanceDto;
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
    public ResponseEntity<StaffAdvance> createAdvance(@Valid @RequestBody StaffAdvanceDto dto) {
        return ResponseEntity.ok(advanceService.createAdvance(dto));
    }

    // Get all advances
    @GetMapping("/alladvance")
    public ResponseEntity<List<StaffAdvance>> getAllAdvances() {
        return ResponseEntity.ok(advanceService.getAllAdvances());
    }

    // Get advances by staff
    @GetMapping("/getadvance/{staffId}")
    public ResponseEntity<List<StaffAdvance>> getAdvancesByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(advanceService.getAdvancesByStaff(staffId));
    }

    // Update advance
    @PutMapping("/update/{id}")
    public ResponseEntity<StaffAdvance> updateAdvance(@PathVariable Long id, @Valid @RequestBody StaffAdvanceDto dto) {
        return ResponseEntity.ok(advanceService.updateAdvance(id, dto));
    }

    // Delete advance
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteAdvance(@PathVariable Long id) {
        advanceService.deleteAdvance(id);
        return ResponseEntity.ok("Advance record deleted successfully");
    }
}
