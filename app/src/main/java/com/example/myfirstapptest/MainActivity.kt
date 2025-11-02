package com.example.myfirstapptest

// Импорт необходимых классов и компонентов
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast  // Импорт класса для показа всплывающих уведомлений
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Включение edge-to-edge отображения (современный дизайн)
        enableEdgeToEdge()

        // Установка макета (UI) для этой Activity
        // R.layout.activity_main ссылается на файл res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // ===================================================================
        // НАХОЖДЕНИЕ КНОПКИ ПО ID
        // ===================================================================

        // val btn_start - объявление неизменяемой переменной (константы)
        // findViewById<Button>() - метод для поиска View в макете по ID
        // R.id.btnStart - ссылка на ID кнопки из XML макета
        val btn_start = findViewById<Button>(R.id.btnStart)

        // ===================================================================
        // РЕГИСТРАЦИЯ ОБРАБОТЧИКА СОБЫТИЙ
        // ===================================================================

        // setOnClickListener - установка слушателя кликов на кнопку
        // {} - лямбда-выражение, код который выполнится при нажатии
        btn_start.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Обработчик ДОЛГОГО нажатия
//        btn_start.setOnLongClickListener {
//            Toast.makeText(this, "Долгое нажатие", Toast.LENGTH_SHORT).show()
//            true // возвращаем true - событие обработано
//        }

        // Toast.makeText() - создание объекта Toast
        // Параметры:
        // 1. this - контекст (текущая Activity)
        // 2. "Идет загрузка магазина" - текст сообщения
        // 3. Toast.LENGTH_SHORT - длительность показа (LENGTH_LONG - длинная)

        // .show() - отображение Toast на экране

    }
}
