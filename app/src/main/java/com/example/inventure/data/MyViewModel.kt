package com.example.inventure.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel(private val dao: ItemDao) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            _items.value = dao.getAllItems()
        }
    }

    fun addItem(item: Item) {
        viewModelScope.launch {
            dao.insertItem(item)
            _items.value = dao.getAllItems() // Refresh list
        }
    }
}