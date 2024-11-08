package com.example.aulaapp02android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.Serializable

class ListItem(val title: String, val image: Int, val genero: String, val idade: Int, val castrado: Boolean): Serializable

class ListAdapter(context: Context, items: List<ListItem>): BaseAdapter() {
    private val context: Context
    private val items: List<ListItem>

    init {
        this.context = context
        this.items = items
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): ListItem {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var myView: View? = convertView
        if (myView == null) {
            myView = LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false)
        }
        val currentItem = getItem(position)
        val title: TextView = myView
            ?.findViewById(R.id.item_title)!!
        val image: ImageView = myView
            .findViewById(R.id.image)!!
        image.setImageResource(currentItem.image)
        title.text = currentItem.title
        return myView
    }
}