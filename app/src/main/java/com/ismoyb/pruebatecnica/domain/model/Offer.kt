package com.ismoyb.pruebatecnica.domain.model

data class Offer(
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
)