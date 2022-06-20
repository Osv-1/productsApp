package com.br.productsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.br.productsapp.R
import com.br.productsapp.adapter.ListProductsAdapter
import com.br.productsapp.dao.ProductDao
import com.br.productsapp.databinding.ActivityFormProductBinding
import com.br.productsapp.databinding.ActivityListProductBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductActivity : AppCompatActivity() {


    private val dao = ProductDao()
    private val adapter = ListProductsAdapter(
        context = this, products = dao.findAll()
    )
    private val binding by lazy {
        ActivityListProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.refresh(dao.findAll())
    }

    private fun configFab() {
        val fabAdd = binding.fabAdd
        fabAdd.setOnClickListener {
            goToFormProduct()
        }
    }

    private fun goToFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

    }


}