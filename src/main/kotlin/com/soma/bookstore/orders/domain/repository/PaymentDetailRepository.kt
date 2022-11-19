package com.soma.bookstore.orders.domain.repository

import com.soma.bookstore.orders.domain.model.PaymentDetail

interface PaymentDetailRepository {

    fun save(paymentDetail: PaymentDetail): PaymentDetail

    fun find(id: Long): PaymentDetail?
}