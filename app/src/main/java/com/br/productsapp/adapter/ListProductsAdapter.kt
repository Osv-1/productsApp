package com.br.productsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.model.Product

class ListProductsAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ListProductsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(product: Product) {

            val name = itemView.findViewById<TextView>(R.id.tv_name)
            name.text = product.name

            val description = itemView.findViewById<TextView>(R.id.tv_desc)
            description.text = product.description

            val price = itemView.findViewById<TextView>(R.id.tv_price)
            price.text = product.price.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.vincula(product)
    }

    override fun getItemCount(): Int = products.size

}