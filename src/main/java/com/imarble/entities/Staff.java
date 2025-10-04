package com.imarble.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="staff")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Staff {
	public enum StaffType {
        MANAGER, DISPATCHER, RECEPTIONIST, WORKER
    }

    public enum SalaryType {
        DAILY, MONTHLY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique=true)
    private String mobile;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private LocalDate joinDate;
    private LocalDate leavingDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StaffType staffType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalaryType salaryType;
    private Double baseSalary;
    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;
    @OneToOne
    @JoinColumn(name = "userid",nullable=true)
    private User user;
}
