package com.soma.bookstore.orders.infrastructure.messaging.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.messaging.OrderProducer
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.infrastructure.messaging.model.OrderMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class OrderProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${kafka.topic.create.order}")
    private val topic: String,
    private val messageMapper: Mapper<OrderMessage, Order>,
    private val objectMapper: ObjectMapper
) : OrderProducer {

    val logger: Logger = LoggerFactory.getLogger("Logger")

    override fun send(order: Order) {
        val message: String = objectMapper.writeValueAsString(
            messageMapper.map(order)
        )
        kafkaTemplate.send(topic, message)
        logger.debug(message)
    }
}