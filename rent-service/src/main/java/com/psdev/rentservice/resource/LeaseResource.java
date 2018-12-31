package com.psdev.rentservice.resource;

import com.psdev.rentservice.model.Lease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import com.psdev.rentservice.repository.LeaseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class LeaseResource {
    @Autowired
    private LeaseRepository leaseRepository;
    @RequestMapping("findByUser")
    public Collection<Lease> findByUser(@Param("userName") String userName) {
        return leaseRepository.findByUserName(userName);
    }
}
