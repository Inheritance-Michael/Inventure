package com.example.inventure



import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel



class ItemViewModel : ViewModel() {
    private val _items = mutableStateListOf<Item>()
    val items: List<Item> get() = _items

    fun addItem(item: Item) {
        _items.add(item)
    }
}