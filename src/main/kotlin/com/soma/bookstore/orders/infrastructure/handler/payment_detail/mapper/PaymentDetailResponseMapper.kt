package com.soma.bookstore.orders.infrastructure.handler.payment_detail.mapper

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.infrastructure.handler.payment_detail.response.PaymentDetailResponse

class PaymentDetailResponseMapper: Mapper<PaymentDetailResponse, PaymentDetail> {

    override fun map(input: PaymentDetail): PaymentDetailResponse {
        return PaymentDetailResponse(
            orderId = input.orderId!!,
            creditNumber = input.creditNumber,
            expirationMonth = input.expirationMonth,
            expirationYear = input.expirationYear,
            cvv = input.cvv
        )
    }

}