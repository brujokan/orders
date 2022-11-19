package com.soma.bookstore.orders.infrastructure.messaging.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.messaging.model.PaymentDetailMessage
import org.springframework.stereotype.Component

@Component
class PaymentDetailMessageMapper: Mapper<PaymentDetailMessage, PaymentDetail> {

    override fun map(input: PaymentDetail): PaymentDetailMessage {
        return PaymentDetailMessage(
            creditNumber = input.creditNumber,
            expirationMonth = input.expirationMonth,
            expirationYear = input.expirationYear,
            cvv = input.cvv
        )
    }
}