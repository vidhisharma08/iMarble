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

import com.imarble.dto.StaffDto;
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
	    public ResponseEntity<Staff> createStaff(@Valid @RequestBody StaffDto dto) {
	        return ResponseEntity.ok(staffService.createStaff(dto));
	    }

	    // Get All Staff
	    @GetMapping("/allstaff")
	    public ResponseEntity<List<Staff>> getAllStaff() {
	        return ResponseEntity.ok(staffService.getAllStaff());
	    }

	    // Get Staff By ID
	    @GetMapping("/getstaff/{id}")
	    public ResponseEntity<Staff> getStaff(@PathVariable Long id) {
	        return ResponseEntity.ok(staffService.getStaffById(id));
	    }

	    // Update Staff
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @Valid @RequestBody StaffDto dto) {
	        return ResponseEntity.ok(staffService.updateStaff(id, dto));
	    }

	    // Delete Staff
	    @DeleteMapping("/del/{id}")
	    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
	        staffService.deleteStaff(id);
	        return ResponseEntity.ok("Staff deleted successfully");
	    }
}
