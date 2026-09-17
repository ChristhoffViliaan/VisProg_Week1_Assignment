package com.example.lib

import java.lang.Thread

class Print(){
    val X = 33 //Amount of lines
    fun printStart(){//Starting Print before anything else
        printLines()
        printCenter("WELCOME")
        printLines()
    }

    fun printEnd(){//Shows before the end of the screen
        printLines()
        printCenter("THANK YOU")
        printLines()
    }

    fun printInput(){
        print("\nInsert Input: ")
    }

    fun printMainMenu(){
        printStart()
        println("1. Make order")
        println("2. View Orders")
        println("3. View Menu")
        println("4. Add Menu")
        println("5. Edit Menu")
        println("6. Delete Menu")
        println("7. Exit")
        printInput()
    }

    fun printMenu(menu: MutableList<Menu>){
        printLines()
        for (i in 0..<(menu.size)) {
            println((i+1).toString() + ". " + menu[i].name + " || " + menu[i].price)
            print(menu[i].description + "\n")
        }
        println("X. Finish Order")
        printInput()
    }

    fun printFullMenu(menu: MutableList<Menu>){
        printLines()
        for (i in 0..<(menu.size)) {
            println((i+1).toString() + ". " + menu[i].name + " || " + menu[i].price)
            print(menu[i].description + "\n")
        }
        Thread.sleep(5000)
    }

    fun printOrderList(orders: MutableList<Order>){
        printLines()
        for (i in 0..<orders.size){
            println((i+1).toString() + ". " + orders[i].name)
        }
        println("X. Exit")
        printInput()
    }

    fun printOrder(order: Order){
        var total : Int = 0
        printLines()
        printCenter("<" + order.name + ">'s ORDER")
        for(i in 0..<order.itemList.size){
            println((i+1).toString() + ". " + order.itemList[i].name + " X" + order.amountList[i].toString() + "\t$" + order.itemList[i].price)
            total = total + (order.amountList[i]*order.itemList[i].price)
        }
        printLines()
        print("TOTAL\t\t$" + total.toString())
        Thread.sleep(1500)
    }
    fun printLines(){
        for (i in 1..X) {
            print("-")
        }
        println()
    }

    fun printMenuNames(menu: MutableList<Menu>){
        printLines()
        for(i in 0..<menu.size){
            println((i+1).toString() + ". " + menu[i].name)
        }
        println("X. Exit")
        printInput()
    }

    fun printEditMenu(Name: String){
        printLines()
        printCenter("Editing <+" + Name + "+>")
        println("1. Edit Name")
        println("2. Edit Description")
        println("3. Edit Price")
        println("X. Exit")
        printInput()
    }
    fun printCenter(Word: String){
        var Return = ""
        var TempSpaces = (X - Word.length) / 2
        if (TempSpaces<1){
            TempSpaces = 0
        }
        for (i in 1..TempSpaces) {
            Return = Return + "-"
        }
        Return = Return + Word
        for (i in 1..TempSpaces) {
            Return = Return + "-"
        }
        println(Return)
    }
}
