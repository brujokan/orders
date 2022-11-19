package com.soma.bookstore.orders.infrastructure.handler.payment_detail.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.handler.payment_detail.request.PaymentDetailCreateRequest
import org.springframework.stereotype.Component

@Component
class PaymentDetailCreateRequestMapper: Mapper<PaymentDetail, PaymentDetailCreateRequest> {

    override fun map(input: PaymentDetailCreateRequest): PaymentDetail {
        return PaymentDetail(
            creditNumber = input.creditNumber,
            expirationMonth = input.expirationMonth,
            expirationYear = input.expirationYear,
            cvv = input.cvv
        )
    }
}