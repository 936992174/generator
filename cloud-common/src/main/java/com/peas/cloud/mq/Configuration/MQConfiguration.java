package com.peas.cloud.mq.Configuration;

import com.peas.cloud.mq.MQConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 一些通用的对象配置
 */
@Configuration
public class MQConfiguration {

    /**
     * 延时消息交换机配置
     * 直连型交换机，根据消息携带的路由键将消息投递给对应队列
     * @return
     */
    @Bean
    DirectExchange ttlExchangeDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(MQConstant.BASIC_EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    /**
     * 主题交换机，这个交换机其实跟直连交换机流程差不多，但是它的特点就是在它的路由键和绑定键之间是有规则的
     * @return
     */
    @Bean
    TopicExchange ttlExchangeTopic() {
        return (TopicExchange) ExchangeBuilder
                .topicExchange(MQConstant.TTL_EXCHANGE_NAME_TOPIC)
                .durable(true)
                .build();
    }

    /**
     * 扇形交换机，没有路由键概念，就算你绑了路由键也是无视的。 这个交换机在接收到消息后，会直接转发到绑定到它上面的所有队列
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(MQConstant.TTL_EXCHANGE_NAME_FANOUT);
    }

}
