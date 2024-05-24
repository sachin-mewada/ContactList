package com.example.contactlist.data.model

data class CustomerResponse(
    val statusCode: String,
    val statusMessage: String,
    val responseData: List<Customer>,
    val responseData1: PaginationInfo
)
