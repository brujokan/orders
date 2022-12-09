package com.soma.bookstore.orders.infrastructure.persistence.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "order", schema = "order")
data class OrderEntity(
    @Id
    val id: Long? = null,
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "purchase_date")
    val purchaseDate: Timestamp,
    @Column(name = "promotion_id")
    val promotionId: Long?,
    val price: Float,
    @Column(name = "product_id")
    val productId: String,
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    val paymentDetail: PaymentDetailEntity? = null
)
