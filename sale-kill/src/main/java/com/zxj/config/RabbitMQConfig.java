package com.zxj.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxj
 * @create 2018/7/11 10:16
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue user() {
        return new Queue("saleKill");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("saleKill");
    }

    @Bean
    Binding bindingExchangeMessages(Queue user, DirectExchange exchange) {
        return BindingBuilder.bind(user).to(exchange).with("saleKill");
    }

}
