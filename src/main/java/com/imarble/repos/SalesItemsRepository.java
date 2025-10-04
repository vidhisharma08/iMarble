package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imarble.entities.SalesItems;

@Repository
public interface SalesItemsRepository extends JpaRepository<SalesItems, Long> {

}
