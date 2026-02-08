package FactoryPattern.AbstractFactoryPattern.cloud.factory;

import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.implementation.S3Storage;
import FactoryPattern.AbstractFactoryPattern.cloud.product.implementation.SQSService;

public class AWSCloudFactory implements CloudFactory {

    @Override
    public MessagingService createMessaging() {
        return new SQSService();
    }

    @Override
    public StorageService createStorage() {
        return new S3Storage();
    }

}
