package com.ritvikproject.RestDemo.Controller;

import com.ritvikproject.RestDemo.Response.ResponseHandler;
import com.ritvikproject.RestDemo.model.CloudVendor;
import com.ritvikproject.RestDemo.service.CloudVendorService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    @Autowired
    CloudVendorService cloudVendorService;
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }


    @GetMapping("")
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }
    @PostMapping("")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created sucessfully";
    }

    @PutMapping("")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated sucessfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);

        return "Cloud vendor deleted sucessfully";
    }
}
