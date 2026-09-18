package com.example.lib

fun main() {
    var orders = mutableListOf<Order>()
    var menu = mutableListOf<Menu>()
    val print = Print()
    var end = false
    do {
        print.printMainMenu()
        when (readInput()){
            "1" -> { //Make a new Order
                if (menu.size == 0){
                    println("Please Make a Menu List First")
                    Thread.sleep(1500)
                } else {
                    print("Enter a Name: ")
                    var NewOrder = Order(readInput())
                    var Input: String? = null
                    print.printMenu(menu)
                    do {
                        Input = readInput()
                        if (isNumber(Input)){
                            if (Input.toInt() in 1..menu.size){
                                print("Amount in order: ")
                                NewOrder.amountList.add(returnNumber())
                                NewOrder.itemList.add(menu[(Input.toInt()-1)])
                                print("Input again: ")
                            } else {
                                print("Menu number doesn't exist")
                                Thread.sleep(1500)
                                println()
                                Input = null
                            }
                        } else if (Input == "X" && NewOrder.itemList.isNotEmpty()){
                            orders.add(NewOrder)
                            print("Order Complete")
                            Thread.sleep(1500)
                            println()
                        } else if (Input == "X"){
                            print("Please add an order")
                            Thread.sleep(1500)
                            println()
                        } else {
                            Input = null
                            print("Reinput: ")
                        }
                    } while (Input != "X" || NewOrder.itemList.isEmpty())
                }
            }
            "2" -> { //View Orders
                var Input: String? = null
                if (orders.isEmpty()) {
                    println("There are no orders")
                    Thread.sleep(1500)
                } else {
                    do {
                        print.printOrderList(orders)
                        Input = readInput()
                        if (isNumber(Input)) {
                            if (Input.toInt() in 1..orders.size) {
                                print.printOrder(orders[(Input.toInt() - 1)])
                            } else {
                                print("Order number doesn't exist")
                            }
                        } else if (Input != "X"){
                            println("Reinput")
                        }
                    } while (Input != "X")
                }
            }
            "3" -> { //View Menu
                if (menu.isEmpty()) {
                    println("Please Make a Menu List First")
                    Thread.sleep(1500)
                } else {
                    print.printFullMenu(menu)
                }
            }
            "4" -> { //add Menu
                print("Insert Name: ")
                var TempName = readInput()
                print("Insert Description: ")
                var TempDescription = readInput()
                print("Insert Price: ")
                var TempPrice : Int = returnNumber()
                menu.add(Menu(TempName, TempDescription, TempPrice))
            }
            "5" -> { //edit Menu
                var Input: String? = null
                var Input2: String? = null
                do {
                    print.printMenuNames(menu)
                    Input = readInput()
                    if (isNumber(Input)){
                        if (Input.toInt() in 1..menu.size){
                            do {
                                print.printEditMenu(menu[(Input.toInt()-1)].name)
                                Input2 = readInput()
                                when (Input2) {
                                    "1" -> {
                                        print("New Name: ")
                                        menu[(Input.toInt() - 1)].name = readInput()
                                    }
                                    "2" -> {
                                        print("New Description: ")
                                        menu[(Input.toInt() - 1)].description = readInput()
                                    }
                                    "3" -> {
                                        print("New Price: ")
                                        menu[(Input.toInt() - 1)].price = returnNumber()
                                    }
                                    else -> {
                                        println("Invalid input")
                                    }
                                }
                            } while (Input2 != "X")
                        } else {
                            print("Menu number doesn't exist")
                        }
                    }
                    if (Input != "X"){
                        println("Reinput")
                    }
                } while(Input != "X")
            }

            "6" -> { //delete Menu
                var Input: String? = null
                do {
                    print.printMenuNames(menu)
                    Input = readInput()
                    if (isNumber(Input)){
                        if (Input.toInt() in 1..menu.size){
                            menu.removeAt(Input.toInt()-1)
                        } else {
                            print("Menu number doesn't exist")
                        }
                    }
                    if (Input != "X"){
                        println("Reinput")
                    }
                } while(Input != "X")
            }

            "7" -> {
                print.printEnd()
                end = true
            }
            else -> {
                println("Invalid input")
            }

        }

    } while (!end)

}

fun readInput(): String{
    var Input: String? = null
    do {
        Input = readlnOrNull()
        if (Input == null){
            print("Reinput: ")
        }
    } while (Input == null)
    return Input
}

fun isNumber(Input: String): Boolean {
    return Input.toIntOrNull() != null
}

fun returnNumber(): Int{
    var Input: String? = null
    var Number: Int? = 0
    var ReturnNumber: Int = 0
    do {
        Input = readlnOrNull()
        Number = Input?.toIntOrNull()
        if (Number == null){
            print("reinput: ")
        } else {
            ReturnNumber = Number
        }
    } while (Number == null)
    return ReturnNumber
}
