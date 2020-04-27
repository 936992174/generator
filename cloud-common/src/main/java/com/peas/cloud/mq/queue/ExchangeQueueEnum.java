package com.peas.cloud.mq.queue;

import com.peas.cloud.mq.MQConstant;
import lombok.Getter;

/**
 * 自定义交换机的队列，若用默认的交换机可直接调用MQSender.send(String exchange, String routingKey, Object message)
 */
@Getter
public enum ExchangeQueueEnum {

    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE(MQConstant.BASIC_EXCHANGE_NAME, "message.queue", "message.key"),

    /**
     * 消息通知A队列
     */
    MESSAGE_TTL_A_QUEUE(MQConstant.TTL_EXCHANGE_NAME_TOPIC, MQConstant.MESSAGE_TTL_QUEUE_A_NAME, "key.a"),

    /**
     * 消息通知*队列
     */
    MESSAGE_TTL_ANY_QUEUE(MQConstant.TTL_EXCHANGE_NAME_TOPIC, MQConstant.MESSAGE_TTL_QUEUE_ANY_NAME, "key.#");


    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    ExchangeQueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

}