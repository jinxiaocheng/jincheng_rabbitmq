package com.jincheng.producer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jincheng
 * @desc
 * @date 2019-5-31 13:37
 */
@Data
public class OrderEntity implements Serializable {

    private String id;

    private String name;

    private String messageId;
}
