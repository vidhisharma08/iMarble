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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    // Create Branch
    @PostMapping("/addbranch")
    public ResponseEntity<Branch> createBranch(@Valid @RequestBody BranchDto dto) {
        return ResponseEntity.ok(branchService.createBranch(dto));
    }

    // Get All Branches
    @GetMapping("/allbranches")
    public ResponseEntity<List<Branch>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    // Get Branch By ID
    @GetMapping("/getbranch/{id}")
    public ResponseEntity<Branch> getBranch(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    // Update Branch
    @PutMapping("/update/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @Valid @RequestBody BranchDto dto) {
        return ResponseEntity.ok(branchService.updateBranch(id, dto));
    }

    // Delete Branch
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok("Branch deleted successfully");
    }
}
