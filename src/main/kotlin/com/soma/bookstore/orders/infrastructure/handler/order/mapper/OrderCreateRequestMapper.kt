package com.soma.bookstore.orders.infrastructure.handler.order.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.handler.order.request.OrderCreateRequest
import com.soma.bookstore.orders.infrastructure.handler.payment_detail.request.PaymentDetailCreateRequest
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.stereotype.Component
import java.sql.Timestamp

@Component
class OrderCreateRequestMapper(
    private val paymentDetailMapper: Mapper<PaymentDetail, PaymentDetailCreateRequest>
): Mapper<Order, OrderCreateRequest> {

    override fun map(input: OrderCreateRequest): Order {
        return Order(
            userId = input.userId,
            promotionId = input.promotionId,
            purchaseDate = Timestamp(System.currentTimeMillis()),
            price = input.price,
            productId = input.productId,
            paymentDetail = paymentDetailMapper.map(input.paymentDetail)
        )
    }
}