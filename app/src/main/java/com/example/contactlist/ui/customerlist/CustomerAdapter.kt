package com.example.contactlist.ui.customerlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.contactlist.R
import com.example.contactlist.data.model.Customer

class CustomerAdapter : ListAdapter<Customer, CustomerAdapter.CustomerViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_customer, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.customerName)
        private val imageView: ImageView = itemView.findViewById(R.id.customerImage)

        fun bind(customer: Customer) {
            val fullName = "${customer.fName} ${customer.mName ?: ""} ${customer.lName}".trim()
            nameTextView.text = fullName
            nameTextView.setTextColor(
                when (adapterPosition % 3) {
                    0 -> itemView.context.getColor(R.color.red)
                    1 -> itemView.context.getColor(R.color.green)
                    else -> itemView.context.getColor(R.color.blue)
                }
            )
            val imageRes = if (customer.isCow == 1) R.drawable.cow else R.drawable.buffalo
            Glide.with(itemView.context).load(imageRes).into(imageView)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Customer>() {
        override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean {
            return oldItem.customerId == newItem.customerId
        }

        override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
            return oldItem == newItem
        }
    }
}