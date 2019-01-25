package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.Lease;
import com.psdev.rentservice.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Lease> findAllLeasesForUser(String username) {
        return leaseRepository.findByUserName(username);
    }
}
