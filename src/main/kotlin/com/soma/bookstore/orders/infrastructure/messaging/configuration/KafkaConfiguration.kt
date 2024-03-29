package com.soma.bookstore.orders.infrastructure.messaging.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfiguration(
    @Value("\${kafka.topic.create.order}")
    private val topic: String
) {


    @Bean
    fun topic(): NewTopic {
        return TopicBuilder
            .name(topic)
            .partitions(2)
            .replicas(1)
            .build()
    }
}
