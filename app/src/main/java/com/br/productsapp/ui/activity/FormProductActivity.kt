package com.br.productsapp.ui.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.br.productsapp.R
import com.br.productsapp.dao.ProductDao
import com.br.productsapp.databinding.ActivityFormProductBinding
import com.br.productsapp.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configSaveBtn()
    }

    private fun configSaveBtn() {
        val saveButton = findViewById<Button>(R.id.btn_save)
        val dao = ProductDao()
        saveButton.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {

        val nameText = binding.etName
        val name = nameText.text.toString()

        val descText = binding.etDesc
        val desc = descText.text.toString()

        val priceText = binding.etPrice
        val priceString = priceText.text.toString()

        val price = if (priceString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceString)
        }
        return Product(
            name = name,
            description = desc,
            price = price
        )
    }
}





