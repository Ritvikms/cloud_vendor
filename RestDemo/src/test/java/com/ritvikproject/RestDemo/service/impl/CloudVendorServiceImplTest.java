package com.ritvikproject.RestDemo.service.impl;

import com.ritvikproject.RestDemo.model.CloudVendor;
import com.ritvikproject.RestDemo.repository.CloudVendorRepository;
import com.ritvikproject.RestDemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class  CloudVendorServiceImplTest {
    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable; // to close all the unwanted resources when the entire class execution is finished
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);// for this class mocks will be opens here and will be called.... and it will close all resources
        cloudVendorService=new CloudVendorServiceImpl();
        cloudVendor=new CloudVendor("1","RItvik","USA","12345");

    }

    @AfterEach
    void tearDown() throws  Exception{
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("successfully created");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("successfully created");
    }

    @Test
    void testToDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");
    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));

        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());

    }

    @Test
    void getAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(
                Collections.singleton(cloudVendor)
        ));

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(cloudVendor.getVendorPhoneNumber());
    }

}