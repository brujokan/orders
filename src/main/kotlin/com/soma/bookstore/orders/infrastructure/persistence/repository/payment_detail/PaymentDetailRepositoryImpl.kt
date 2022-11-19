package com.soma.bookstore.orders.infrastructure.persistence.repository.payment_detail

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.model.PaymentDetail
import com.soma.bookstore.orders.domain.repository.PaymentDetailRepository
import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import com.soma.bookstore.orders.infrastructure.persistence.jpa.PaymentDetailRepositoryJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PaymentDetailRepositoryImpl(
    private val repositoryJPA: PaymentDetailRepositoryJPA,
    private val entityMapper: Mapper<PaymentDetailEntity, PaymentDetail>,
    private val modelMapper: Mapper<PaymentDetail, PaymentDetailEntity>
): PaymentDetailRepository {
    override fun save(paymentDetail: PaymentDetail): PaymentDetail {
        return modelMapper.map(repositoryJPA.save(entityMapper.map(paymentDetail)))
    }

    override fun find(id: Long): PaymentDetail? {
        return modelMapper.map(repositoryJPA.findByIdOrNull(id) ?: return null)
    }
}