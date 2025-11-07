package com.example.myfirstapptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Получаем данные из Intent
        val productName = intent.getStringExtra("name") ?: "Товар"
        val productPrice = intent.getDoubleExtra("price", 0.0)
        val productImageRes = intent.getIntExtra("imageRes", 0)
        val productDescription = intent.getStringExtra("description") ?: "Описание отсутствует"

        // Находим все View на экране
        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailName = findViewById<TextView>(R.id.detailName)
        val detailPrice = findViewById<TextView>(R.id.detailPrice)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        val buyButton = findViewById<Button>(R.id.buyButton)
        val backButton = findViewById<Button>(R.id.backButton)

        // Заполняем данными
        detailImage.setImageResource(productImageRes)
        detailName.text = productName
        detailPrice.text = "${productPrice} ₽"
        detailDescription.text = productDescription

        // Обработчик кнопки "КУПИТЬ"
        buyButton.setOnClickListener {
            Toast.makeText(this, "Товар \"$productName\" добавлен в корзину!", Toast.LENGTH_SHORT).show()
        }

        // Обработчик кнопки "Назад"
        backButton.setOnClickListener {
            finish() // Закрываем текущую активность и возвращаемся назад
        }
    }
}