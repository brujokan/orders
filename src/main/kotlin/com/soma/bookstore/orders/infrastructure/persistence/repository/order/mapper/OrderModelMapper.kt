package com.soma.bookstore.orders.infrastructure.persistence.repository.order.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.persistence.entity.OrderEntity
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.stereotype.Component

@Component
class OrderModelMapper(
    private val paymentDetailMapper: Mapper<PaymentDetail, PaymentDetailEntity>
): Mapper<Order, OrderEntity> {

    override fun map(input: OrderEntity): Order {
        return Order(
            id = input.id,
            userId = input.userId,
            purchaseDate = input.purchaseDate,
            promotionId = input.promotionId,
            price = input.price,
            paymentDetail = paymentDetailMapper.map(input.paymentDetail!!),
            productId = input.productId
        )
    }
}