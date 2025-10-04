package com.imarble.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	 boolean existsByTitle(String title);
}
