package com.example.contactlist.ui.customerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.data.model.Customer
import com.example.contactlist.data.repository.CustomerRepository
import kotlinx.coroutines.launch

class CustomerViewModel(private val repository: CustomerRepository) : ViewModel() {
    private val _customers = MutableLiveData<List<Customer>>()
    val customers: LiveData<List<Customer>> get() = _customers

    fun fetchCustomers(pageNo: Int, pageSize: Int, unitId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getCustomerDetails(pageNo, pageSize, unitId)
                _customers.value = response.body()?.responseData
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}