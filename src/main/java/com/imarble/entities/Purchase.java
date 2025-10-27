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
@Table(name="purchases")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Purchase { 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
	@Column(nullable = false)
    private Double billAmount;
	@Column(nullable = false,unique=true)
    private String invoiceNumber;
	
    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "clientid",nullable=false)
    private Clients client;

}
