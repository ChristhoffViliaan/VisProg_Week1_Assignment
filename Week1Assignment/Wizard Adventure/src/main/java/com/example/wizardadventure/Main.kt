package com.example.lib
import kotlin.random.Random


fun main() {
    while(true) {
        val print = Print()
        print.Start()
        var wiz = Wizard(ReadName())
        print.delayPrint("\nGood luck, " + wiz.Name + "!", 30)
        print.delay(800)
        print.delayPrint(" You're gonna need it!\n", 30)
        print.delay(1500)
        print.printlnplus(50)
        var end = false
        do {
            print.Menu1()
            when (Answers(listOf("1", "2"))) {
                "1" -> {
                    do {
                        print.Menu2(wiz)
                        var Input = Answers(listOf("a", "b", "c", "d"))
                        when (Input){
                            "a" -> {
                                wiz.Heal("H")
                            }
                            "b" -> {
                                wiz.Heal("M")
                            }
                            "c" -> {
                                print.delayPrint("What would you like your new name to be?\n", 30)
                                wiz.Name = ReadName()
                            }
                        }
                    } while (Input != "d")
                }

                "2" -> {
                    val mon = when (Random.nextInt(1, 4)) {
                        1 -> Mon("Firemon", wiz.Kills)
                        2 -> Mon("Watermon", wiz.Kills)
                        3 -> Mon("Grassmon", wiz.Kills)
                        else -> error("Invalid monster number")
                    }
                    do {
                        print.Menu3(wiz, mon)
                        var dmgT: Char = 'X'
                        var Input = Answers(listOf("a", "b", "c", "d", "e"))
                        var run = false
                        when (Input) {
                            "a" -> {
                                dmgT = 'F'
                            }
                            "b" -> {
                                dmgT = 'W'
                            }
                            "c" -> {
                                dmgT = 'G'
                            }
                            "d" -> {
                                print.Menu4()
                                when (Answers(listOf("1", "2"))){
                                    "1" -> {
                                        wiz.Heal("H")
                                    }
                                    "2" -> {
                                        wiz.Heal("M")
                                    }
                                }
                            }
                            "e" -> {
                                run = true
                            }
                        }
                        if (run){
                            print.delayPrint("You decided to flee from battle", 30)
                            print.delay(1000)
                            println()
                        } else if (dmgT != 'X' && wiz.Mana > 0) {
                            wiz.LifeSteal(mon.TakeDamage(dmgT, wiz.Damage))
                            wiz.Mana = wiz.Mana - 10
                        } else {
                            print.delayPrint("You are out of mana...", 30)
                        }
                        if (!run && mon.Hp > 0){
                            wiz.TakeDamage(mon.Damage)
                        }
                    } while (wiz.Hp > 0 && mon.Hp > 0 && !run)
                    if (wiz.Hp == 0){
                        end = true
                    } else if (mon.Hp == 0){
                        print.delayPrint("You have slain the " + mon.Name,30)
                        print.delay(1000)
                        println()
                        wiz.Kills = wiz.Kills + 1
                        wiz.evolve()
                    }
                }
            }
        } while (!end)
        print.End(wiz)
    }
}


fun ReadName(): String{
    var Input: String? = null
    do {
        Input = readlnOrNull()
        if (Input == null){
            print("Reinput: ")
        }
    } while (Input == null)
    return Input
}

fun Answers(answer: List<String>):String {
    var Input: String? = null
    do {
        Input = readlnOrNull()
        if (Input == null || Input !in answer){
            print("Reinput: ")
        }
    } while (Input == null || Input !in answer)
    return Input
}
