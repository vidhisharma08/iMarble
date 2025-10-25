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
@Table(name="brands")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Brand {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandid;
	@Column(nullable = false,unique=true)
    private String title;
    private String image;
    @Column(nullable = false)
    private Boolean status;
}
