package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imarble.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
