package com.example.aulaapp02android

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = intent.getSerializableExtra("listItem") as ListItem?
        if (data != null) {
            var image = findViewById<ImageView>(R.id.imageView)
            var nome = findViewById<TextView>(R.id.nomeValue)
            var genero = findViewById<TextView>(R.id.generoValue)
            var idade = findViewById<TextView>(R.id.idadeValue)
            var castrado = findViewById<TextView>(R.id.castradoValue)

            image.setImageResource(data.image)
            nome.text = data.title
            genero.text = data.genero
            idade.text = data.idade.toString()
            castrado.text = if (data.castrado) "Sim" else "Não"
        }
    }
}