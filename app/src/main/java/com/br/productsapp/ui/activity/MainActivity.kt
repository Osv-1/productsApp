package com.br.productsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.adapter.ListProductsAdapter
import com.br.productsapp.model.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListProductsAdapter(
            context = this, products = listOf(
                Product(
                    name = "teste",
                    description = "teste descricao",
                    price = BigDecimal("19.99")
                ), Product(
                    name = "teste 2",
                    description = "teste descricao 2",
                    price = BigDecimal("10.99")
                )
            )
        )
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAdd.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }

    }
}