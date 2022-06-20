package com.br.productsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.adapter.ListProductsAdapter
import com.br.productsapp.dao.ProductDao
import com.br.productsapp.model.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onResume() {
        super.onResume()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val dao = ProductDao()

        recyclerView.adapter = ListProductsAdapter(
            context = this, products = dao.findAll()
        )

        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAdd.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }


}