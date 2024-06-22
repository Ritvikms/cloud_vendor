package com.ritvikproject.RestDemo.service.impl;

import com.ritvikproject.RestDemo.exeption.CloudVendorNotFoundException;
import com.ritvikproject.RestDemo.model.CloudVendor;
import com.ritvikproject.RestDemo.repository.CloudVendorRepository;
import com.ritvikproject.RestDemo.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    @Autowired
    CloudVendorRepository cloudVendorRepository;

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "successfully created";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "updated successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }


}
