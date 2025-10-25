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
@Table(name="subcategories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubCategory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcateid;
	@Column(nullable = false)
    private String title;
    private String scdesc;
    private String image;
    @Column(nullable = false)
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "cateid", nullable = false)
    private Category category;
}
