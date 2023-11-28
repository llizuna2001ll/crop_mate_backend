package com.brogrammers.cropservice.exceptions;

public class CropNotFoundException extends RuntimeException {
    public CropNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
