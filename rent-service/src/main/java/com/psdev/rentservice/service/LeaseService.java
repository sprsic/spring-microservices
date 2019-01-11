package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.Lease;

import java.util.List;


public interface LeaseService {
    /**
     * Finds all leases for a given user
     *
     */
    List<Lease> findAllLeasesForUser(String username);
}
