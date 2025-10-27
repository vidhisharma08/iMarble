package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.StaffSalaryDto;
import com.imarble.dto.ApiResponse;
import com.imarble.entities.StaffSalary;
import com.imarble.services.StaffSalaryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staff-salary")
public class StaffSalaryController {

    @Autowired
    private StaffSalaryService salaryService;

    // Create salary
    @PostMapping("/addsalary")
    public ResponseEntity<ApiResponse<StaffSalary>> createSalary(@Valid @RequestBody StaffSalaryDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Salary created successfully", salaryService.createSalary(dto))
        );
    }

    // Get all salaries
    @GetMapping("/allsalaries")
    public ResponseEntity<ApiResponse<List<StaffSalary>>> getAllSalaries() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All salaries fetched successfully", salaryService.getAllSalaries())
        );
    }

    // Get salaries by staff
    @GetMapping("/getsalary/{staffId}")
    public ResponseEntity<ApiResponse<List<StaffSalary>>> getSalariesByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Salaries fetched successfully for staff", salaryService.getSalariesByStaff(staffId))
        );
    }

    // Update salary
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<StaffSalary>> updateSalary(@PathVariable Long id,
                                                                 @Valid @RequestBody StaffSalaryDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Salary updated successfully", salaryService.updateSalary(id, dto))
        );
    }

    // Delete salary
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Salary record deleted successfully", null)
        );
    }
}
