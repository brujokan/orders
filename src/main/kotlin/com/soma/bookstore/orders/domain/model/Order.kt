package com.soma.bookstore.orders.domain.model

import java.sql.Timestamp

data class Order(
    val id: Long? = null,
    val userId: Long,
    val purchaseDate: Timestamp,
    val promotionId: Long?,
    val price: Float,
    val productId: String,
    val paymentDetail: PaymentDetail? = null
)
