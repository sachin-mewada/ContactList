package com.example.contactlist.ui.customerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.R
import com.example.contactlist.data.api.RetrofitInstance
import com.example.contactlist.data.repository.CustomerRepository
import com.example.contactlist.ui.common.ViewModelFactory

class CustomerListFragment : Fragment() {
    private lateinit var viewModel: CustomerViewModel
    private lateinit var adapter: CustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customer_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = CustomerRepository(RetrofitInstance.api)
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(CustomerViewModel::class.java)

        adapter = CustomerAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter

        viewModel.customers.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        viewModel.fetchCustomers(1, 10, 787)

        view.findViewById<Button>(R.id.searchButton).setOnClickListener {
            val searchQuery = view.findViewById<EditText>(R.id.searchEditText).text.toString()
            // Implement search functionality
        }
    }
}