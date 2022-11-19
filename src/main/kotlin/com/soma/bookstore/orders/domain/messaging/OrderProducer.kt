package com.soma.bookstore.orders.domain.messaging

import com.soma.bookstore.orders.domain.model.Order

interface OrderProducer {

    fun send(order: Order)
}