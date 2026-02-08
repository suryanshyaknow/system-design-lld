package FactoryPattern.AbstractFactoryPattern.cloud.factory;

import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.implementation.GCSStorage;
import FactoryPattern.AbstractFactoryPattern.cloud.product.implementation.PubSubService;

public class GCPCloudFactory implements CloudFactory {

    @Override
    public MessagingService createMessaging() {
        return new PubSubService();
    }

    @Override
    public StorageService createStorage() {
        return new GCSStorage();
    }
}
