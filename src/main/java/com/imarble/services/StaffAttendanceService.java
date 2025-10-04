package com.imarble.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imarble.dto.StaffAttendanceDto;
import com.imarble.entities.Staff;
import com.imarble.entities.StaffAttendance;
import com.imarble.mapper.StaffAttendanceMapper;
import com.imarble.repos.StaffAttendanceRepository;
import com.imarble.repos.StaffRepository;

@Service
public class StaffAttendanceService {

    @Autowired
    private StaffAttendanceRepository attendanceRepository;

    @Autowired
    private StaffRepository staffRepository;

    public StaffAttendance markAttendance(StaffAttendanceDto dto) {
        Staff staff = staffRepository.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

        // Prevent duplicate attendance entry for same date
        if (attendanceRepository.findByStaff_StaffIdAndDate(dto.getStaffId(), dto.getDate()).isPresent()) {
            throw new RuntimeException("Attendance already marked for this staff on " + dto.getDate());
        }

        StaffAttendance attendance = StaffAttendanceMapper.toEntity(dto, staff);
        return attendanceRepository.save(attendance);
    }

    public List<StaffAttendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<StaffAttendance> getAttendanceByStaff(Long staffId) {
        return attendanceRepository.findAll().stream()
                .filter(a -> a.getStaff().getStaffId().equals(staffId))
                .toList();
    }

    public StaffAttendance updateAttendance(Long id, StaffAttendanceDto dto) {
        StaffAttendance existing = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id " + id));

        Staff staff = staffRepository.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found with id " + dto.getStaffId()));

        existing.setStaff(staff);
        existing.setDate(dto.getDate());
        existing.setStatus(dto.getStatus());

        return attendanceRepository.save(existing);
    }

    public void deleteAttendance(Long id) {
        StaffAttendance existing = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id " + id));
        attendanceRepository.delete(existing);
    }
}
