package com.peas.cloud.mq.Configuration;

import com.peas.cloud.mq.queue.ExchangeQueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnyTtlConfiguration {

    /**
     * 所有字母队列
     * @return
     */
    @Bean
    Queue anyTtlQueue() {
        return QueueBuilder
                .durable(ExchangeQueueEnum.MESSAGE_TTL_ANY_QUEUE.getName())
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", ExchangeQueueEnum.MESSAGE_TTL_ANY_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", ExchangeQueueEnum.MESSAGE_TTL_ANY_QUEUE.getRouteKey())
                .build();
    }

    @Bean
    public Binding anyTtlBinding(TopicExchange ttlExchangeTopic) {
        return BindingBuilder
                .bind(anyTtlQueue())
                .to(ttlExchangeTopic)
                .with(ExchangeQueueEnum.MESSAGE_TTL_ANY_QUEUE.getRouteKey());
    }
}
