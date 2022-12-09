package com.soma.bookstore.orders.application.use_case.order.save

import com.soma.bookstore.orders.domain.messaging.OrderProducer
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.repository.OrderRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SaveOrderUseCase(
    private val repository: OrderRepository,
    private val producer: OrderProducer
) {

    private val logger = KotlinLogging.logger {  }
    @Transactional
    fun save(order: Order): Order {
        val orderSaved: Order = repository.save(order)

        try {
            producer.send(orderSaved)
        } catch (ex: Exception) {
            logger.error { "Could not send order ${ex.message}" }
        }


        return orderSaved
    }

}