package com.soma.bookstore.orders.infrastructure.persistence.repository.order

import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.repository.OrderRepository
import com.soma.bookstore.orders.infrastructure.persistence.entity.OrderEntity
import com.soma.bookstore.orders.infrastructure.persistence.jpa.OrderRepositoryJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val repositoryJPA: OrderRepositoryJPA,
    private val entityMapper: Mapper<OrderEntity, Order>,
    private val modelMapper: Mapper<Order, OrderEntity>
    ): OrderRepository {
    override fun save(order: Order): Order {
        return modelMapper.map(repositoryJPA.save(entityMapper.map(order)))
    }

    override fun find(id: Long): Order? {
       return modelMapper.map(repositoryJPA.findByIdOrNull(id) ?: return null)
    }

    override fun findAll(): List<Order> {
        return repositoryJPA.findAll().map(modelMapper::map)
    }
}