package com.soma.bookstore.orders.infrastructure.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "payment_details", schema = "order")
data class PaymentDetailEntity(
    @Id
    @GeneratedValue(generator = "orderSeq")
    @SequenceGenerator(name = "orderSeq", sequenceName = "ORDER_SEQUENCE", allocationSize = 1, schema = "order")
    @Column(name = "order_id")
    val id: Long? = null,
    @Column(name = "credit_number")
    val creditNumber: Long,
    @Column(name = "expiration_month")
    val expirationMonth: String,
    @Column(name = "expiration_year")
    val expirationYear: String,
    val cvv: String
)
