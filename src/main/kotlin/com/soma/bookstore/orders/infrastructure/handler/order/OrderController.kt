package com.soma.bookstore.orders.infrastructure.handler.order

import com.soma.bookstore.orders.application.use_case.order.find.FindOrderUseCase
import com.soma.bookstore.orders.application.use_case.order.find_all.FindAllOrderUseCase
import com.soma.bookstore.orders.application.use_case.order.save.SaveOrderUseCase
import com.soma.bookstore.orders.domain.mapper.Mapper
import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.infrastructure.handler.order.request.OrderCreateRequest
import com.soma.bookstore.orders.infrastructure.handler.order.response.OrderResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/order")
class OrderController(
    private val createUseCase: SaveOrderUseCase,
    private val findUseCase: FindOrderUseCase,
    private val findAllUseCase: FindAllOrderUseCase,
    private val requestMapper: Mapper<Order, OrderCreateRequest>,
    private val responseMapper: Mapper<OrderResponse, Order>
) {

    @Operation(
        summary = "Create new order",
        description = "Create new order",
        operationId = "create"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Order successfully created"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @PostMapping
    fun create(@RequestBody payload: OrderCreateRequest): ResponseEntity<Void> {
        val order: Order = createUseCase.save(requestMapper.map(payload))
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
            .buildAndExpand(order.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find order by id",
        description = "Find order by id",
        operationId = "Find"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Order found"),
        ApiResponse(responseCode = "400", description = "Bad request"),
        ApiResponse(responseCode = "404", description = "Not found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): ResponseEntity<OrderResponse> {
        return ResponseEntity.ok(responseMapper.map(findUseCase.find(id)))
    }

    @Operation(
        summary = "Find all orders",
        description = "Find all orders",
        operationId = "Find"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Orders found"),
        ApiResponse(responseCode = "500", description = "Internal server error")
    ])
    @GetMapping
    fun findAll(): ResponseEntity<List<OrderResponse>> {
        return ResponseEntity.ok(
            findAllUseCase.findAll().map(responseMapper::map)
        )
    }
}