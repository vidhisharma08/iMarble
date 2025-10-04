package com.imarble.repos;

import com.imarble.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    // Optional: find by title if needed
    boolean existsByTitle(String title);
}
