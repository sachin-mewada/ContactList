package com.example.contactlist.data.model

data class Customer(
    val customerId: Int,
    val fName: String,
    val mName: String?,
    val lName: String,
    val mobileNo: String,
    val isCow: Int,
    val isBuffalo: Int
)
