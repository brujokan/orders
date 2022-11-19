package com.soma.bookstore.orders.application.use_case.order.find

import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.repository.OrderRepository
import com.soma.bookstore.orders.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FindOrderUseCase(
    private val repository: OrderRepository
) {
    fun find(id: Long): Order {
        return repository.find(id) ?: throw NotFoundException("Order with id ${id} not found")
    }
}