package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.StaffSalaryDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffSalary;
import com.imarble.mapper.StaffSalaryMapper;
import com.imarble.repos.StaffRepository;
import com.imarble.repos.StaffSalaryRepository;

@Service
public class StaffSalaryService {
	   @Autowired
	    private StaffSalaryRepository salaryRepository;

	    @Autowired
	    private StaffRepository staffRepository;

	    public StaffSalary createSalary(StaffSalaryDto dto) {
	        Staff staff = staffRepository.findById(dto.getStaffId())
	                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

	        StaffSalary salary = StaffSalaryMapper.toEntity(dto, staff);
	        return salaryRepository.save(salary);
	    }

	    public List<StaffSalary> getAllSalaries() {
	        return salaryRepository.findAll();
	    }

	    public List<StaffSalary> getSalariesByStaff(Long staffId) {
	        return salaryRepository.findByStaff_StaffId(staffId);
	    }

	    public StaffSalary updateSalary(Long id, StaffSalaryDto dto) {
	        StaffSalary existing = salaryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Salary record not found with id " + id));

	        Staff staff = staffRepository.findById(dto.getStaffId())
	                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

	        existing.setStaff(staff);
	        existing.setMonth(dto.getMonth());
	        existing.setYear(dto.getYear());
	        existing.setPaymentDate(dto.getPaymentDate());
	        existing.setAmount(dto.getAmount());
	        existing.setMode(dto.getMode());
	        existing.setDescription(dto.getDescription());

	        return salaryRepository.save(existing);
	    }

	    public void deleteSalary(Long id) {
	        StaffSalary existing = salaryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Salary record not found with id " + id));
	        salaryRepository.delete(existing);
	    }
}
