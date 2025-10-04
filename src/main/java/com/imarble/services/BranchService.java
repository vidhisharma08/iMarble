package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.BranchDto;
import com.imarble.entities.Branch;
import com.imarble.mapper.BranchMapper;
import com.imarble.repos.BranchRepository;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public Branch createBranch(BranchDto dto) {
        if (branchRepository.findByMobile(dto.getMobile()).isPresent()) {
            throw new RuntimeException("Mobile number already exists for another branch");
        }
        Branch branch = BranchMapper.toEntity(dto);
        return branchRepository.save(branch);
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found with id " + id));
    }

    public Branch updateBranch(Long id, BranchDto dto) {
        Branch existing = getBranchById(id);
        existing.setName(dto.getName());
        existing.setAddress(dto.getAddress());
        existing.setMobile(dto.getMobile());
        existing.setStatus(dto.getStatus());
        return branchRepository.save(existing);
    }

    public void deleteBranch(Long id) {
        Branch existing = getBranchById(id);
        branchRepository.delete(existing);
    }
}
