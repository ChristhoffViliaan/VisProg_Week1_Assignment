package com.example.lib

class Order (val name: String){
    val itemList = mutableListOf<Menu>()
    val amountList = mutableListOf<Int>()
}