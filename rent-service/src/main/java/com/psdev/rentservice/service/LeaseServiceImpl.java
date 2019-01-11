package com.psdev.rentservice.service;

import com.psdev.rentservice.model.Lease;
import com.psdev.rentservice.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    public List<Lease> findAllLeasesForUser(String username) {
        return leaseRepository.findByUserName(username);
    }
}
