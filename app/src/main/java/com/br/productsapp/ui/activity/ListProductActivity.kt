package com.br.productsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.adapter.ListProductsAdapter
import com.br.productsapp.dao.ProductDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductActivity : AppCompatActivity(R.layout.activity_list_product) {

    private val dao = ProductDao()
    private val adapter = ListProductsAdapter(
        context = this, products = dao.findAll()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.findAll())
    }

    private fun configFab() {
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAdd.setOnClickListener {
            goToFormProduct()
        }
    }

    private fun goToFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter

    }


}