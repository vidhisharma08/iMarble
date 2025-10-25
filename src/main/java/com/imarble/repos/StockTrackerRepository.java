package com.imarble.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imarble.entities.StockTracker;
@Repository
public interface StockTrackerRepository extends JpaRepository<StockTracker, Long> {



	@Query("SELECT COALESCE(SUM(CASE WHEN s.type = 'PURCHASE' THEN s.qty ELSE 0 END), 0) - " +
	           "COALESCE(SUM(CASE WHEN s.type IN ('SALES', 'MISSING') THEN s.qty ELSE 0 END), 0) " +
	           "FROM StockTracker s WHERE s.product.pid = :productId")
	Integer calculateFinalStock(Long productId);


	List<StockTracker> findByProductPid(Long productId);

}
