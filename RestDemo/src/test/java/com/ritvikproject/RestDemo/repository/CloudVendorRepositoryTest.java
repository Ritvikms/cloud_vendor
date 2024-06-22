package com.ritvikproject.RestDemo.repository;

import com.ritvikproject.RestDemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest       // used to let springboot know that it should use embedded in memory database for data or database related activities
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;
    @BeforeEach
    void setUp() {
        cloudVendor= new CloudVendor("1","Ritvik","USA","123456789");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor=null;
        cloudVendorRepository.deleteAll();
    }
    //test case success
    @Test
    void  testFindByVendorName_Found(){
        List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("Ritvik");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }
    @Test
    void  testFindByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList=cloudVendorRepository.findByVendorName("UCM");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }
}
