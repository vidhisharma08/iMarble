package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imarble.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
