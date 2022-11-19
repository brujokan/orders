package com.soma.bookstore.orders.infrastructure.handler.order.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.infrastructure.handler.order.response.OrderResponse
import org.springframework.stereotype.Component

@Component
class OrderResponseMapper: Mapper<OrderResponse, Order> {

    override fun map(input: Order): OrderResponse {
        return OrderResponse(
            input.id!!,
            input.userId,
            input.purchaseDate,
            input.promotionId,
            input.price,
            input.productId,
            input.paymentDetail!!
        )
    }
}