package com.br.productsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.br.productsapp.R
import com.br.productsapp.dao.ProductDao
import com.br.productsapp.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saveButton = findViewById<Button>(R.id.btn_save)
        saveButton.setOnClickListener {

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

            val newProduct = Product(
                name = name,
                description = desc,
                price = price
            )
            val dao = ProductDao()
            dao.add(newProduct)
        }

    }


}