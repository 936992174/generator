package com.peas.cloud.mq;


public class MQConstant {

    /**
     * ttl(延时)交换机名称
     */
    public static final String TTL_EXCHANGE_NAME_TOPIC = "message.ttl.topic.exchange";

    /**
     * ttl(延时)扇形交换机名称
     */
    public static final String TTL_EXCHANGE_NAME_FANOUT = "message.ttl.fanout.exchange";

    /**
     * 基本交换机名称
     */
    public static final String BASIC_EXCHANGE_NAME = "message.basic.exchange";

    /**
     * A消息通知队列名称
     */
    public static final String MESSAGE_TTL_QUEUE_A_NAME = "message.ttl.queue.a";

    /**
     * 任意字符消息通知队列名称
     */
    public static final String MESSAGE_TTL_QUEUE_ANY_NAME = "message.ttl.queue.*";

}
