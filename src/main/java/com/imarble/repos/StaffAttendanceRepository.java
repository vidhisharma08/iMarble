package com.imarble.repos;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.StaffAttendance;
@Repository
public interface StaffAttendanceRepository extends JpaRepository<StaffAttendance, Long> {

	Optional<StaffAttendance> findByStaff_StaffIdAndDate(Long staffId, LocalDate date);

}
