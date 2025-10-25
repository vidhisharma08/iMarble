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

import com.imarble.dto.StaffSalaryDto;
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
    public ResponseEntity<StaffSalary> createSalary(@Valid @RequestBody StaffSalaryDto dto) {
        return ResponseEntity.ok(salaryService.createSalary(dto));
    }

    // Get all salaries
    @GetMapping("/allsalaries")
    public ResponseEntity<List<StaffSalary>> getAllSalaries() {
        return ResponseEntity.ok(salaryService.getAllSalaries());
    }

    // Get salaries by staff
    @GetMapping("/getsalary/{staffId}")
    public ResponseEntity<List<StaffSalary>> getSalariesByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(salaryService.getSalariesByStaff(staffId));
    }

    // Update salary
    @PutMapping("/update/{id}")
    public ResponseEntity<StaffSalary> updateSalary(@PathVariable Long id,
                                                    @Valid @RequestBody StaffSalaryDto dto) {
        return ResponseEntity.ok(salaryService.updateSalary(id, dto));
    }

    // Delete salary
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok("Salary record deleted successfully");
    }
}
