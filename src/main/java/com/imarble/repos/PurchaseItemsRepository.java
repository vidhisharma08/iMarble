package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imarble.entities.PurchaseItems;

public interface PurchaseItemsRepository extends JpaRepository<PurchaseItems, Long> {

}
