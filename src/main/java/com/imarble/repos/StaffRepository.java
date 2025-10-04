package com.imarble.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

	Optional<Staff> findByMobile(String mobile);

}
