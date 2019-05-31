package com.jincheng.producer.order;

import com.jincheng.producer.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jincheng
 * @desc
 * @date 2019-5-31 13:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void send() {
        orderSender.send();
    }

}
