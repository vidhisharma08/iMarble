package com.imarble.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.Branch;
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

	Optional<Branch> findByMobile(String mobile);

}
