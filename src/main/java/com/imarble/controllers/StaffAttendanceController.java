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

import com.imarble.dto.StaffAttendanceDto;
import com.imarble.entities.StaffAttendance;
import com.imarble.services.StaffAttendanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staff-attendance")
public class StaffAttendanceController {
    @Autowired
    private StaffAttendanceService attendanceService;

    // Mark attendance
    @PostMapping("/markattendance")
    public ResponseEntity<StaffAttendance> markAttendance(@Valid @RequestBody StaffAttendanceDto dto) {
        return ResponseEntity.ok(attendanceService.markAttendance(dto));
    }

    // Get all attendance
    @GetMapping("/allattendance")
    public ResponseEntity<List<StaffAttendance>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    // Get attendance by staff
    @GetMapping("/getattendance/{staffId}")
    public ResponseEntity<List<StaffAttendance>> getAttendanceByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(attendanceService.getAttendanceByStaff(staffId));
    }

    // Update attendance
    @PutMapping("/update/{id}")
    public ResponseEntity<StaffAttendance> updateAttendance(@PathVariable Long id, @Valid @RequestBody StaffAttendanceDto dto) {
        return ResponseEntity.ok(attendanceService.updateAttendance(id, dto));
    }

    // Delete attendance
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.ok("Attendance deleted successfully");
    }
}
