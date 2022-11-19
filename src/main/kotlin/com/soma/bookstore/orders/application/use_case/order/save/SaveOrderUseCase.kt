package com.soma.bookstore.orders.application.use_case.order.save

import com.soma.bookstore.orders.domain.messaging.OrderProducer
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.repository.OrderRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SaveOrderUseCase(
    private val repository: OrderRepository,
    private val producer: OrderProducer
) {
    @Transactional
    fun save(order: Order): Order {
        val orderSaved: Order = repository.save(order)
        producer.send(orderSaved)

        return orderSaved
    }

}