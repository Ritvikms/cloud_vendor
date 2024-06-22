package com.ritvikproject.RestDemo.exeption;

public class CloudVendorNotFoundException extends RuntimeException{
    public CloudVendorNotFoundException(String message){
        super(message);
    }
}
