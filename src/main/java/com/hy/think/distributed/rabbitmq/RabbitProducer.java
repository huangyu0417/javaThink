package com.hy.think.distributed.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/9/19 14:16
 */
public class RabbitProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitProducer producer = new RabbitProducer();
        producer.sendMessage();
    }

    public void sendMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("47.98.173.139");
        factory.setPort(8672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("test-queue", false, false, false, null);
        channel.basicPublish("", "test-queue", null, "hello".getBytes());
        channel.close();
        connection.close();
    }

}
