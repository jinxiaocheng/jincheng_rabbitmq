package com.jincheng.producer.producer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jincheng.producer.entity.OrderEntity;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author jincheng
 * @desc 订单发送相关
 * @date 2019-5-31 13:41
 */
@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @desc 发送消息到rabbitmq
     * @author jincheng
     * @date 2019-5-31 13:52
     */
    public void send(OrderEntity orderEntity) {

        orderEntity.setId(UUID.randomUUID().toString());
        orderEntity.setName("订单测试");
        orderEntity.setMessageId(UUID.randomUUID().toString());

        // 发送消息到 “order-exchange” 交换机里
        rabbitTemplate.convertAndSend("order-exchange", "order-a", JSON.toJSONString(orderEntity));

    }

}
