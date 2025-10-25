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
@Table(name="missing_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissingItems {
	public enum MissingItemType {
	    MISSING, DAMAGE
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missid;
    @Column(nullable = false)
    private Integer qty;
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MissingItemType type;
    @ManyToOne
    @JoinColumn(name = "productid",nullable=false)
    private Product product;
}
