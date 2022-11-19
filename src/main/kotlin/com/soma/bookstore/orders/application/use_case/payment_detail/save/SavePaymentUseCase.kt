package com.soma.bookstore.orders.application.use_case.payment_detail.save

import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.domain.repository.PaymentDetailRepository
import org.springframework.stereotype.Service

@Service
class SavePaymentUseCase(
    private val repository: PaymentDetailRepository
) {
//    fun save(payment: PaymentDetail): PaymentDetail {
//        return repository.save(payment)
//    }
}