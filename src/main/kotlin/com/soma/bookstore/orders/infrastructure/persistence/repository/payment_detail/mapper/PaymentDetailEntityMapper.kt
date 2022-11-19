package com.soma.bookstore.orders.infrastructure.persistence.repository.payment_detail.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.persistence.entity.OrderEntity
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.stereotype.Component

@Component
class PaymentDetailEntityMapper(): Mapper<PaymentDetailEntity, PaymentDetail> {

    override fun map(input: PaymentDetail): PaymentDetailEntity {
        return PaymentDetailEntity(
            input.orderId,
            input.creditNumber,
            input.expirationMonth,
            input.expirationYear,
            input.cvv
        )
    }
}