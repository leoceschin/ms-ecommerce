package com.msecommerce.inventory.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig {

    FanoutExchange fanoutExchange = new FanoutExchange("products.v1.sender");

    @Bean
    public Queue insertProduct(){
        return new Queue("insert-product-queue", true);
        
    }

    public Binding bindingInsert(){

        return BindingBuilder.bind(insertProduct()).to(fanoutExchange);
    }



    @Bean
    public RabbitAdmin rabbitAdmin (ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    public ApplicationListener<ApplicationReadyEvent> applicationListener(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;

    }

}
