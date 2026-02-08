package FactoryPattern.AbstractFactoryPattern.cloud.client;

import FactoryPattern.AbstractFactoryPattern.cloud.factory.AWSCloudFactory;
import FactoryPattern.AbstractFactoryPattern.cloud.factory.CloudFactory;
import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;

public class Main {

    public static void main(String[] args) {
        CloudFactory awsCloudFactory = new AWSCloudFactory();
        StorageService awsStorage = awsCloudFactory.createStorage();
        MessagingService messagingService = awsCloudFactory.createMessaging();

        awsStorage.store("data");
        messagingService.send("hello");
    }

}
