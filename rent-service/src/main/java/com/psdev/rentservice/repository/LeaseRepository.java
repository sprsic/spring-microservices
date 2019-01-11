package com.psdev.rentservice.repository;

import com.psdev.rentservice.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaseRepository extends JpaRepository<Lease, Long> {

    @Query("FROM Lease l where l.user.userName = :name")
    List<Lease> findByUserName(String name);
}
