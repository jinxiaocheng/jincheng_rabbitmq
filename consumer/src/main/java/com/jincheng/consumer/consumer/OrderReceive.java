package com.jincheng.consumer.consumer;

import com.alibaba.fastjson.JSON;
import com.jincheng.consumer.entity.OrderEntity;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author jincheng
 * @desc 订单消费相关
 * @date 2019-6-3 10:48
 */
@Component
public class OrderReceive {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "order-exchange", type = "topic"),
            value = @Queue(name = "order-quque", durable = "true"),
            key = "order-a"))
    @RabbitHandler
    public void onOrderMessage(@Payload String string, @Headers Map<String, Object> headers, Channel channel) {
        // 消费者操作
        System.out.println("消费者开始消费");
        OrderEntity orderEntity = JSON.parseObject(string, OrderEntity.class);
        System.out.println(orderEntity.toString());

        // ack，消息被消费之后，通知rabbitmq，删除消息
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
