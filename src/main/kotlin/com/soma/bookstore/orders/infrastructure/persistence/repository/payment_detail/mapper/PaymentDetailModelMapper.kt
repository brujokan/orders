package com.soma.bookstore.orders.infrastructure.persistence.repository.payment_detail.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.stereotype.Component

@Component
class PaymentDetailModelMapper: Mapper<PaymentDetail, PaymentDetailEntity> {

    override fun map(input: PaymentDetailEntity): PaymentDetail {
        return PaymentDetail(
            input.id,
            input.creditNumber,
            input.expirationMonth,
            input.expirationYear,
            input.cvv
        )
    }
}