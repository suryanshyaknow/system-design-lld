package FactoryPattern.AbstractFactoryPattern.cloud.product.implementation;

import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;

public class S3Storage implements StorageService {

    @Override
    public void store(String data) {
        System.out.println("Storing in AWS S3...");
    }

}
