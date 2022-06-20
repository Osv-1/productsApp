package com.br.productsapp.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.productsapp.R
import com.br.productsapp.dao.ProductDao
import com.br.productsapp.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        val nameText = findViewById<EditText>(R.id.et_name)
        val name = nameText.text.toString()

        val descText = findViewById<EditText>(R.id.et_desc)
        val desc = descText.text.toString()

        val priceText = findViewById<EditText>(R.id.et_price)
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





