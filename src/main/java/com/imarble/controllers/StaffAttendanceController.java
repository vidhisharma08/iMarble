package com.imarble.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imarble.dto.StaffAttendanceDto;
import com.imarble.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<StaffAttendance>> markAttendance(@Valid @RequestBody StaffAttendanceDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Attendance marked successfully", attendanceService.markAttendance(dto))
        );
    }

    // Get all attendance
    @GetMapping("/allattendance")
    public ResponseEntity<ApiResponse<List<StaffAttendance>>> getAllAttendance() {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "All attendance records fetched successfully", attendanceService.getAllAttendance())
        );
    }

    // Get attendance by staff
    @GetMapping("/getattendance/{staffId}")
    public ResponseEntity<ApiResponse<List<StaffAttendance>>> getAttendanceByStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Attendance records fetched successfully for staff ID: " + staffId,
                attendanceService.getAttendanceByStaff(staffId))
        );
    }

    // Update attendance
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<StaffAttendance>> updateAttendance(@PathVariable Long id, @Valid @RequestBody StaffAttendanceDto dto) {
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Attendance updated successfully", attendanceService.updateAttendance(id, dto))
        );
    }

    // Delete attendance
    @DeleteMapping("/del/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Attendance record deleted successfully", null)
        );
    }
}
