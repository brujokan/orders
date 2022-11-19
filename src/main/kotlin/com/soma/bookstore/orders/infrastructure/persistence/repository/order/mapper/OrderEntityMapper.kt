package com.soma.bookstore.orders.infrastructure.persistence.repository.order.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.persistence.entity.OrderEntity
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.stereotype.Component

@Component
class OrderEntityMapper(
    private val paymentMapper: Mapper<PaymentDetailEntity, PaymentDetail>
): Mapper<OrderEntity, Order> {

    override fun map(input: Order): OrderEntity {
        return OrderEntity(
            input.id,
            input.userId,
            input.purchaseDate,
            input.promotionId,
            input.price,
            input.productId,
            paymentMapper.map(input.paymentDetail!!)
        )
    }
}