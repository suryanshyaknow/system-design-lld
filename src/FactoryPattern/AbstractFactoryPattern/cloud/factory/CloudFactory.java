package FactoryPattern.AbstractFactoryPattern.cloud.factory;

import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;
import FactoryPattern.AbstractFactoryPattern.cloud.product.StorageService;

public interface CloudFactory {

    MessagingService createMessaging();

    StorageService createStorage();

}
