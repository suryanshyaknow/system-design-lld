package FactoryPattern.AbstractFactoryPattern.cloud.product.implementation;

import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;

public class PubSubService implements MessagingService {

    @Override
    public void send(String msg) {
        System.out.println("Sending message via Google's PubSub Service: " + msg);
    }

}
