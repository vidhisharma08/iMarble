package com.imarble.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.StaffSalary;
@Repository
public interface StaffSalaryRepository extends JpaRepository<StaffSalary, Long> {

	List<StaffSalary> findByStaff_StaffId(Long staffId);

}
