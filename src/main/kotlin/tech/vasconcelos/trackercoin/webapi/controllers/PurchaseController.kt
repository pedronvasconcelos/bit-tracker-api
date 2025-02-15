package tech.vasconcelos.trackercoin.webapi.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseRequest
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseResponse
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseUseCase
import tech.vasconcelos.trackercoin.webapi.base.BaseResponse

interface PurchaseController {

    @Operation(
        summary = "Create a new purchase",
        description = "Creates a new purchase with the provided purchase details"
    )
    @PostMapping("/api/purchases")
    fun createPurchase(@RequestBody request: CreatePurchaseRequest): ResponseEntity<BaseResponse<CreatePurchaseResponse>>
}