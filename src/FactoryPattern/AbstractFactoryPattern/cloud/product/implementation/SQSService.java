package FactoryPattern.AbstractFactoryPattern.cloud.product.implementation;

import FactoryPattern.AbstractFactoryPattern.cloud.product.MessagingService;

public class SQSService implements MessagingService {

    @Override
    public void send(String msg) {
        System.out.println("Sending message via Amazon's SQS service: " + msg);
    }

}
