package com.soma.bookstore.orders.domain.mapper

interface Mapper<T, V> {
    fun map(input: V): T
}