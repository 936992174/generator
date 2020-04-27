package com.peas.cloud.mq.Configuration;

import com.peas.cloud.mq.queue.ExchangeQueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATtlConfiguration {

    /**
     * demoA 队列
     * @return
     */
    @Bean
    Queue aTtlQueue() {
        return QueueBuilder
                .durable(ExchangeQueueEnum.MESSAGE_TTL_A_QUEUE.getName())
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", ExchangeQueueEnum.MESSAGE_TTL_A_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", ExchangeQueueEnum.MESSAGE_TTL_A_QUEUE.getRouteKey())
                .build();
    }

    /**
     * ttl队列和ttl交换机的绑定-routeKey
     * ttlExchangeTopic 交换机在MQConfiguration中注入
     * @return
     */
    @Bean
    public Binding aTtlBinding(TopicExchange ttlExchangeTopic) {
        return BindingBuilder
                .bind(aTtlQueue())
                .to(ttlExchangeTopic)
                .with(ExchangeQueueEnum.MESSAGE_TTL_A_QUEUE.getRouteKey());
    }
}
