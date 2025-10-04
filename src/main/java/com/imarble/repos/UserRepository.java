package com.imarble.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imarble.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByMobile(String mobile);

}
