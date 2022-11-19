package com.soma.bookstore.orders.infrastructure.messaging.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentDetailMessage(
    @JsonProperty("credit_number")
    val creditNumber: Long,
    @JsonProperty("expiration_month")
    val expirationMonth: String,
    @JsonProperty("expiration_year")
    val expirationYear: String,
    @JsonProperty("cvv")
    val cvv: String
)
