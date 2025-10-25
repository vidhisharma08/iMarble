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
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="dispatch_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DispatchItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "disid",nullable=false)
    private SalesDispatch dispatch;

    @ManyToOne
    @JoinColumn(name = "sitemsid",nullable=false)
    private SalesItems salesItem;
}
