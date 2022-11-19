package com.soma.bookstore.orders.infrastructure.messaging.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class OrderMessage(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("user_id")
    val userId: Long,
    @JsonProperty("purchase_date")
    val purchaseDate: Timestamp,
    @JsonProperty("promotion_id")
    val promotionId: Long?,
    @JsonProperty("price")
    val price: Float,
    @JsonProperty("product_id")
    val productId: Float,
    @JsonProperty("payment_detail")
    val paymentDetail: PaymentDetailMessage
)
