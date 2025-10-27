package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.MissingItems;
@Repository
public interface MissingItemRepository extends JpaRepository<MissingItems, Long> {

}
