package com.br.productsapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.databinding.ProdutoItemBinding
import com.br.productsapp.model.Product

class ListProductsAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ListProductsAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(product: Product) {
            val name = binding.tvName
            name.text = product.name
            val description = binding.tvDesc
            description.text = product.description
            val price = binding.tvPrice
            price.text = product.price.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.vincula(product)
    }

    override fun getItemCount(): Int = products.size


    @SuppressLint("NotifyDataSetChanged")
    fun refresh(products: List<Product>) {

        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}