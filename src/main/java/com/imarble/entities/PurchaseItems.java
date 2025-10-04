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
@Table(name="purchase_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PurchaseItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "productid",nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchaseid",nullable=false)
    private Purchase purchase;
}
