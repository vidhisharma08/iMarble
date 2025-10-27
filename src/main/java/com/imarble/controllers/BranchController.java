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

import com.imarble.dto.BranchDto;
import com.imarble.entities.Branch;
import com.imarble.services.BranchService;
import com.imarble.dto.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Create Branch
    @PostMapping("/addbranch")
    public ResponseEntity<ApiResponse<Branch>> createBranch(@Valid @RequestBody BranchDto dto) {
        Branch branch = branchService.createBranch(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Branch created successfully", branch));
    }

    // Get All Branches
    @GetMapping("/allbranches")
    public ResponseEntity<ApiResponse<List<Branch>>> getAllBranches() {
        List<Branch> branches = branchService.getAllBranches();
        return ResponseEntity.ok(new ApiResponse<>(true, "Branches fetched successfully", branches));
    }

    // Get Branch By ID
    @GetMapping("/getbranch/{id}")
    public ResponseEntity<ApiResponse<Branch>> getBranch(@PathVariable Long id) {
        Branch branch = branchService.getBranchById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Branch fetched successfully", branch));
    }

    // Update Branch
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Branch>> updateBranch(@PathVariable Long id, @Valid @RequestBody BranchDto dto) {
        Branch updatedBranch = branchService.updateBranch(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Branch updated successfully", updatedBranch));
    }

    // Delete Branch
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Branch deleted successfully", null));
    }
}
