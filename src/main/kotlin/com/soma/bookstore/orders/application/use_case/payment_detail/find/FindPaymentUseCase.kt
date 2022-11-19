package com.soma.bookstore.orders.application.use_case.payment_detail.find

import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.domain.repository.PaymentDetailRepository
import com.soma.bookstore.orders.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FindPaymentUseCase(
    private val repository: PaymentDetailRepository
) {
    fun find(id: Long): PaymentDetail {
        return repository.find(id) ?: throw NotFoundException("Payment with id ${id} not found")
    }
}