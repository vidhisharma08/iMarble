package com.imarble.entities;

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
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="stock_tracker")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockTracker {
	public enum StockType {
	    PURCHASE, SALES, MISSING
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackerid;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockType type;  
    @Column(nullable = false)
    private Long referenceid;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Boolean status; 

    @ManyToOne
    @JoinColumn(name = "productid",nullable=false)
    private Product product;
}
