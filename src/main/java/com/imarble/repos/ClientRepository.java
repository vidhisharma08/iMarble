package com.imarble.repos;

import com.imarble.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
    boolean existsByMobile(String mobile);
    boolean existsByEmail(String email);
}
