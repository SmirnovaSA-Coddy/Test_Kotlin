package com.example.myfirstapptest

import Product
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    // Список товаров
    private val products = listOf(
        Product(1, "Кольцо 1", 50.0, "Описание 1",R.drawable.one),
        Product(2, "Кольцо2", 30.0, "Описание 2",R.drawable.two),
        Product(3, "Цепочка1", 40.0, "Описание 3",R.drawable.three),
        Product(4, "Цепочка2", 60.0, "Описание 4",R.drawable.four),
        Product(5, "Браслет", 70.0, "Описание 5",R.drawable.five)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Находим контейнер для товаров
        val container = findViewById<LinearLayout>(R.id.catalogContainer)

        // Для каждого товара создаем карточку
        products.forEach { product ->
            // 1. Создаем View из шаблона item_product.xml
            val view = layoutInflater.inflate(R.layout.item_product, container, false)

            // 2. Заполняем данными товара
            view.findViewById<ImageView>(R.id.ivProductImage).setImageResource(product.ImageRes)
            view.findViewById<TextView>(R.id.tvProductName).text = product.name
            view.findViewById<TextView>(R.id.tvProductPrice).text = "${product.price} $"

            view.findViewById<Button>(R.id.btnDetails).setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("name", product.name)
                    putExtra("price", product.price)
                    putExtra("imageRes", product.ImageRes)
                    putExtra("description", product.description)
                }
                startActivity(intent)
            }

            // 3. Добавляем карточку в контейнер
            container.addView(view)


        }

    }
}