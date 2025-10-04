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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="sales")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sales {
	public enum SalesStatus {
	    BOOKED, DISPATCHED, DONE
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    public enum SalesType {
        CUSTOMER, DEALER
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesType type;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private double billAmount;
    @Column(nullable = false,unique=true)
    private String invoiceNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SalesStatus status;

    @ManyToOne
    @JoinColumn(name = "clientid",nullable=false)
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "branchid",nullable=false)
    private Branch branch;
}
