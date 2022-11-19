package com.soma.bookstore.orders.infrastructure.handler.payment_detail.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

@Schema(description = "Model for payment detail", name = "paymentDetail")
data class PaymentDetailCreateRequest(
    @field:Schema(name = "credit_number",required = true, description = "Number of the credit card")
    @NotNull(message = "Required")
    @JsonProperty("credit_number")
    val creditNumber: Long,
    @field:Schema(name = "expiration_month",required = true, description = "Expiration month of the card")
    @NotNull(message = "Required")
    @JsonProperty("expiration_month")
    val expirationMonth: String,
    @field:Schema(name = "expiration_year",required = true, description = "Expiration year of the card")
    @NotNull(message = "Required")
    @JsonProperty("expiration_year")
    val expirationYear: String,
    @field:Schema(name = "cvv",required = true, description = "cvv of the card")
    @NotNull(message = "Required")
    val cvv: String
)
