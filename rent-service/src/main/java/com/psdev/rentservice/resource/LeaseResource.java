package com.psdev.rentservice.resource;

import com.psdev.rentservice.model.Lease;
import com.psdev.rentservice.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaseResource {
    @Autowired
    private LeaseService leaseService;
    @RequestMapping("lease/findByUser")
    public List<Lease> findByUser(@Param("userName") String userName) {
        return leaseService.findAllLeasesForUser(userName);
    }
}
