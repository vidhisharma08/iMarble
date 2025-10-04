package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.StaffAdvanceDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffAdvance;
import com.imarble.mapper.StaffAdvanceMapper;
import com.imarble.repos.StaffAdvanceRepository;
import com.imarble.repos.StaffRepository;

@Service
public class StaffAdvanceService {
    @Autowired
    private StaffAdvanceRepository advanceRepository;

    @Autowired
    private StaffRepository staffRepository;

    public StaffAdvance createAdvance(StaffAdvanceDto dto) {
        Staff staff = staffRepository.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

        StaffAdvance advance = StaffAdvanceMapper.toEntity(dto, staff);
        return advanceRepository.save(advance);
    }

    public List<StaffAdvance> getAllAdvances() {
        return advanceRepository.findAll();
    }

    public List<StaffAdvance> getAdvancesByStaff(Long staffId) {
        return advanceRepository.findByStaff_StaffId(staffId);
    }

    public StaffAdvance updateAdvance(Long id, StaffAdvanceDto dto) {
        StaffAdvance existing = advanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advance record not found with id " + id));

        Staff staff = staffRepository.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

        existing.setStaff(staff);
        existing.setMonth(dto.getMonth());
        existing.setYear(dto.getYear());
        existing.setPaymentDate(dto.getPaymentDate());
        existing.setAmount(dto.getAmount());
        existing.setMode(dto.getMode());

        return advanceRepository.save(existing);
    }

    public void deleteAdvance(Long id) {
        StaffAdvance existing = advanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advance record not found with id " + id));
        advanceRepository.delete(existing);
    }
}
