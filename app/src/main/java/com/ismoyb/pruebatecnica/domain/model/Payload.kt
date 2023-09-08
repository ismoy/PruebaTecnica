package com.ismoyb.pruebatecnica.domain.model
data class Payload(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)