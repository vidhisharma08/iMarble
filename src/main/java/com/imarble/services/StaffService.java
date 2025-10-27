package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.StaffDto;
import com.imarble.entities.Branch;
import com.imarble.entities.Staff;
import com.imarble.entities.User;
import com.imarble.mapper.StaffMapper;
import com.imarble.repos.BranchRepository;
import com.imarble.repos.StaffRepository;
import com.imarble.repos.UserRepository;

@Service
public class StaffService {
	   @Autowired
	    private StaffRepository staffRepository;

	    @Autowired
	    private BranchRepository branchRepository;

	    @Autowired
	    private UserRepository userRepository;

	    public Staff createStaff(StaffDto dto) {
	        if (staffRepository.findByMobile(dto.getMobile()).isPresent()) {
	            throw new RuntimeException("Mobile number already exists for another staff");
	        }

	        Branch branch = null;
	        if (dto.getBranchId() != null) {
	            branch = branchRepository.findById(dto.getBranchId())
	                    .orElseThrow(() -> new RuntimeException("Branch not found with id " + dto.getBranchId()));
	        }

	        User user = null;
	        if (dto.getUserId() != null) {
	            user = userRepository.findById(dto.getUserId())
	                    .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));
	        }

	        Staff staff = StaffMapper.toEntity(dto, branch, user);
	        return staffRepository.save(staff);
	    }

	    public List<Staff> getAllStaff() {
	        return staffRepository.findAll();
	    }

	    public Staff getStaffById(Long id) {
	        return staffRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Staff not found with id " + id));
	    }

	    public Staff updateStaff(Long id, StaffDto dto) {
	        Staff existing = getStaffById(id);

	        existing.setName(dto.getName());
	        existing.setMobile(dto.getMobile());
	        existing.setAddress(dto.getAddress());
	        existing.setJoinDate(dto.getJoinDate());
	        existing.setLeavingDate(dto.getLeavingDate());
	        existing.setStaffType(dto.getStaffType());
	        existing.setSalaryType(dto.getSalaryType());
	        existing.setBaseSalary(dto.getBaseSalary());

	        if (dto.getBranchId() != null) {
	            Branch branch = branchRepository.findById(dto.getBranchId())
	                    .orElseThrow(() -> new RuntimeException("Branch not found with id " + dto.getBranchId()));
	            existing.setBranch(branch);
	        }

	        if (dto.getUserId() != null) {
	            User user = userRepository.findById(dto.getUserId())
	                    .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));
	            existing.setUser(user);
	        }

	        return staffRepository.save(existing);
	    }

	    public void deleteStaff(Long id) {
	        Staff existing = getStaffById(id);
	        staffRepository.delete(existing);
	    }
}
