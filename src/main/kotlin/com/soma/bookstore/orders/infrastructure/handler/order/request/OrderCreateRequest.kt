package com.soma.bookstore.orders.infrastructure.handler.order.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.soma.bookstore.orders.infrastructure.handler.payment_detail.request.PaymentDetailCreateRequest
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

@Schema(description = "Model for order created", name = "order")
data class OrderCreateRequest(
    @field:Schema(name = "user_id", required = true, description = "Id of the user")
    @NotNull(message = "Required")
    @JsonProperty("user_id")
    val userId: Long,
    @field:Schema(name = "promotion_id",required = true, description = "Id of the promotion applied")
    @JsonProperty("promotion_id")
    val promotionId: Long?,
    @field:Schema(required = true, description = "Order price")
    @NotNull(message = "Required")
    val price: Float,
    @field:Schema(name = "product_id",required = true, description = "Id of the purchased product")
    @JsonProperty("product_id")
    @NotNull(message = "Required")
    val productId: String,
    @field:Schema(name = "payment_detail",required = true, description = "Payment detail card")
    @JsonProperty("payment_detail")
    @NotNull(message = "Required")
    val paymentDetail: PaymentDetailCreateRequest
)
