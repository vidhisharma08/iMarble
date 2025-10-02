package com.imarble.entities;

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
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
	@Column(nullable = false,unique=true)
    private String modelNumber; 
	@Column(nullable = false)
    private String title;
	@Column(nullable = false)
    private Integer unit;          
    private String prodesc;
    @Column(nullable = false)
    private Double pricePerUnit;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private Integer minStockLevel;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "cateid",nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcateid",nullable=false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "brandid",nullable=false)
    private Brand brand;
}
