package com.soma.bookstore.orders.infrastructure.handler.exception_handler

import com.soma.bookstore.orders.exception.NotFoundException
import com.soma.bookstore.orders.exception.model.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class OrderServiceExceptionHandler {

    @ExceptionHandler
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity(ErrorMessageModel(404, ex.message!!), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleBadRequestException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorMessageModel> {
        return ResponseEntity(ErrorMessageModel(400, ex.message!!), HttpStatus.BAD_REQUEST)
    }
}