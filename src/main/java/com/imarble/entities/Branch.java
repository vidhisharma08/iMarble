package com.imarble.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="branch")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Branch {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String address;
	@Column(nullable = false, unique = true)
    private String mobile;
    private Boolean status;
}
