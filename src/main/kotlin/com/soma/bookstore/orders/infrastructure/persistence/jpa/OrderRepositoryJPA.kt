package com.soma.bookstore.orders.infrastructure.persistence.jpa

import com.soma.bookstore.orders.infrastructure.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepositoryJPA: JpaRepository<OrderEntity, Long>