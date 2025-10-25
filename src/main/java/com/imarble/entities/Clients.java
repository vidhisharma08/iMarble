package com.imarble.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clients { 
	public enum ClientType {
	    PURCHASE_DEALER, SALES_DEALER, CLIENT
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientid;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false, unique=true)
    private String mobile;
	@Column(unique = true)
    private String email;
    private String address;
    private String gstnumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientType type;
}
