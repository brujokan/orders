package com.soma.bookstore.orders.infrastructure.messaging.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.messaging.model.OrderMessage
import com.soma.bookstore.orders.infrastructure.messaging.model.PaymentDetailMessage
import org.springframework.stereotype.Component

@Component
class OrderMessageMapper(
    private val paymentDetailMapper: Mapper<PaymentDetailMessage, PaymentDetail>
): Mapper<OrderMessage, Order> {

    override fun map(input: Order): OrderMessage {
        return OrderMessage(
            id = input.id!!,
            userId = input.userId,
            purchaseDate = input.purchaseDate,
            promotionId = input.promotionId,
            price = input.price,
            productId = input.productId,
            paymentDetail = paymentDetailMapper.map(input.paymentDetail!!)
        )
    }
}