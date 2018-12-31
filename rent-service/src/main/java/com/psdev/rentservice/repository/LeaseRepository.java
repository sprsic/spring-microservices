package com.psdev.rentservice.repository;

import com.psdev.rentservice.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
    @Query("FROM Lease l where l.user.userName = :name")
    Collection<Lease> findByUserName(String name);
}
