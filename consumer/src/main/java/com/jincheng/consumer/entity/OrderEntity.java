package com.jincheng.consumer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jincheng
 * @desc
 * @date 2019-5-31 13:37
 */
@Data
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 6843855054172116493L;

    private String id;

    private String name;

    private String messageId;

}
