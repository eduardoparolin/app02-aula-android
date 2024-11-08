package com.example.aulaapp02android

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val items: List<ListItem> = listOf(
        ListItem("Fifo", R.drawable.dog1, "Macho", 1, true),
        ListItem("Lulinha", R.drawable.dog2, "Fêmea", 2, true),
        ListItem("Fofinho", R.drawable.dog3, "Macho", 8, false),
        ListItem("Azula", R.drawable.dog4, "Fêmea", 1, true),
        ListItem("Zé", R.drawable.dog5, "Macho", 3, true),
        ListItem("Pupito", R.drawable.dog6, "Macho", 10, false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.my_list)

        list.setAdapter(ListAdapter(this@MainActivity, items))
        list.setOnItemClickListener(fun (_, _, position, _) {
            val intent = Intent(this, DogActivity::class.java)
            intent.putExtra("listItem", items[position])
            startActivity(intent)
        })
    }
}