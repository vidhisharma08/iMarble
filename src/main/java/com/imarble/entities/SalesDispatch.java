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
@Table(name="sales_dispatch")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SalesDispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disid;
    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "dispatcherid",nullable=false)
    private Staff dispatcher;

    @ManyToOne
    @JoinColumn(name = "salesid",nullable=false)
    private Sales sales;

}
