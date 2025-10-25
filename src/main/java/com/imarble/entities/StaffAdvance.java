package com.imarble.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="staff_advance")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StaffAdvance {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advanceId;
    @ManyToOne
    @JoinColumn(name = "staffid",nullable = false)
    private Staff staff;
	@Column(nullable = false)
    private Integer month;
	@Column(nullable = false)
    private Integer year;
	@Column(nullable = false)
    private LocalDate paymentDate;
	@Column(nullable = false)
    private Double amount;
	@Column(nullable = false)
    private String mode;

}
