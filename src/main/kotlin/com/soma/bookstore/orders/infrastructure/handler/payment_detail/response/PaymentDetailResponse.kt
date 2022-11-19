package com.soma.bookstore.orders.infrastructure.handler.payment_detail.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentDetailResponse(
    @JsonProperty("order_id")
    val orderId: Long,
    @JsonProperty("credit_number")
    val creditNumber: Long,
    @JsonProperty("expiration_month")
    val expirationMonth: String,
    @JsonProperty("expiration_year")
    val expirationYear: String,
    @JsonProperty("cvv")
    val cvv: String
)
