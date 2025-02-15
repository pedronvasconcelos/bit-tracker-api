package tech.vasconcelos.trackercoin.webapi.controllers.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseRequest
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseResponse
import tech.vasconcelos.trackercoin.application.usecases.purchases.CreatePurchaseUseCase
import tech.vasconcelos.trackercoin.webapi.base.BaseResponse
import tech.vasconcelos.trackercoin.webapi.controllers.PurchaseController

@RestController
class PurchaseControllerImpl(private val createPurchaseUseCase: CreatePurchaseUseCase) : PurchaseController{

    override fun createPurchase(request: CreatePurchaseRequest): ResponseEntity<BaseResponse<CreatePurchaseResponse>> =
        createPurchaseUseCase.execute(request)
            .let { purchaseResponse ->
                ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BaseResponse(data = purchaseResponse))
            }
}