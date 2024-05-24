package com.example.contactlist.data.api

import com.example.contactlist.data.model.CustomerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/CustomerDetails/GetCustomerDetails")
    suspend fun getCustomerDetails(
        @Query("pageno") pageNo: Int,
        @Query("pagesize") pageSize: Int,
        @Query("UnitId") unitId: Int
    ): Response<CustomerResponse>
}