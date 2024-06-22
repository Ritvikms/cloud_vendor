package com.ritvikproject.RestDemo.repository;

import com.ritvikproject.RestDemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
    List<CloudVendor> findByVendorName(String vendorName);
}
