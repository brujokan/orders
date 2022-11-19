package com.soma.bookstore.orders.infrastructure.persistence.jpa

import com.soma.bookstore.orders.infrastructure.persistence.entity.PaymentDetailEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentDetailRepositoryJPA: JpaRepository<PaymentDetailEntity, Long>