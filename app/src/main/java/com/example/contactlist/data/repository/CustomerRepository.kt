package com.example.contactlist.data.repository

import com.example.contactlist.data.api.ApiService
import com.example.contactlist.data.model.CustomerResponse
import retrofit2.Response

class CustomerRepository(private val apiService: ApiService) {
    suspend fun getCustomerDetails(pageNo: Int, pageSize: Int, unitId: Int): Response<CustomerResponse> {
        return apiService.getCustomerDetails(pageNo, pageSize, unitId)
    }
}