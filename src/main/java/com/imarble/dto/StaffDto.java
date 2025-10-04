package com.imarble.dto;

import java.time.LocalDate;

import com.imarble.entities.Staff.SalaryType;
import com.imarble.entities.Staff.StaffType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StaffDto {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Mobile is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
    private String mobile;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Join date is required")
    private LocalDate joinDate;

    private LocalDate leavingDate;

    @NotNull(message = "Staff type is required")
    private StaffType staffType;

    @NotNull(message = "Salary type is required")
    private SalaryType salaryType;

    private Double baseSalary;

    private Long branchId;
    private Long userId;   
}
