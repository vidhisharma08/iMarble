package com.imarble.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.StaffAdvance;
@Repository
public interface StaffAdvanceRepository extends JpaRepository<StaffAdvance, Long> {

	List<StaffAdvance> findByStaff_StaffId(Long staffId);

}
