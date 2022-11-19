package com.soma.bookstore.orders.domain.model

data class PaymentDetail(
    val orderId: Long? = null,
    val creditNumber: Long,
    val expirationMonth: String,
    val expirationYear: String,
    val cvv: String
)
