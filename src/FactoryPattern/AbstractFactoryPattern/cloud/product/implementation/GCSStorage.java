package FactoryPattern.AbstractFactoryPattern.cloud.product.implementation;

import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;

public class GCSStorage implements StorageService {

    @Override
    public void store(String data) {
        System.out.println("Storing " + data + "  in GCS Storage...");
    }

}
