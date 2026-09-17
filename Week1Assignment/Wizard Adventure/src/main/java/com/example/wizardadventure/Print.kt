package com.example.lib

class Print {
    fun Start(){
        printLines()
        printCenter("Wizard Adventure!")
        printLines()
        println()
        delayPrint("You're a wizard that's been researching in a tower for several years when you find out that after\n" +
                "killing enough enemies and absorbing their essence, you can evolve into a stronger wizard and\n" +
                "develop an attribute that can make yourself immortal... With this revelation in mind, you venture\n" +
                "off into the nearby forest in hopes of evolving yourself", 30)
        delayPrint("...  ", 1000)
        delayPrint("\n\nWhats your name?",30)
        println()
    }

    fun Menu1(){
        printLines()
        printCenter("Wizard Adventure!")
        printLines()
        delayPrint("1. View Stats", 20)
        delayPrint("\n2. Enter Battle", 20)
        delayPrint("\n\nWhat do you do?", 20)
        println()
    }

    fun Menu2(wiz : Wizard){
        printCenter("<" + wiz.Name + ">'s STATS")
        delayPrint("HP: " + wiz.Hp.toString() + "/" + wiz.MaxHp.toString(), 20)
        delayPrint("\nMana: " + wiz.Mana.toString() + "/" + wiz.MaxMana.toString(), 20)
        if (wiz.WizardType.equals("Weak")){
            delayPrint("\nKills needed to evolve: " + wiz.Kills.toString() + "/5", 20)
        } else {
            delayPrint("\nTotal kills: " + wiz.Kills.toString(), 20)
        }
        delayPrint("\nMana Potions held: " + wiz.ManaPod.toString() + "/5", 20)
        delayPrint("\nHealth Potions held: " + wiz.HealthPod.toString() + "/5\n", 20)
        printLines()
        delayPrint("\ta. Drink Mana Potion", 20)
        delayPrint("\n\tb. Drink Health Potion", 20)
        delayPrint("\n\tc. Rename self", 20)
        delayPrint("\n\td. back", 20)
        delayPrint("\n\nWhat do you do?", 20)
        println()
    }

    fun Menu3(wiz: Wizard, mon: Mon){
        printCenter("BATTLE")
        delayPrint(wiz.Name, 10)
        delayPrint("\nHP: " + wiz.Hp + "/" + wiz.MaxHp, 10)
        delayPrint("\nMana: " + wiz.Mana + "/" + wiz.MaxMana, 10)
        delayPrint("\nHP Potions: " + wiz.HealthPod, 10)
        delayPrint("\nMP Potions: " + wiz.ManaPod, 10)
        delayPrint("\n\n" + mon.Name, 10)
        delayPrint("\nHP: " + mon.Hp + "/" + mon.MaxHp, 10)
        delayPrint("\nType: " + mon.Name.removeSuffix("mon") + "\n",10)
        printLines()
        delayPrint("\ta. Fire Attack", 10)
        delayPrint("\n\tb. Water Attack", 10)
        delayPrint("\n\tc. Grass Attack", 10)
        delayPrint("\n\td. Drink potion", 10)
        delayPrint("\n\te. Run", 10)
        delayPrint("\n\nWhat do you do?", 20)
        println()
    }

    fun Menu4 (){
        printLines()
        delayPrint("\t1. Drink Health Potion", 10)
        delayPrint("\n\t2. Drink Mana Potion", 10)
        delayPrint("\n\nWhat do you do?", 20)
    }


    fun End(wiz : Wizard){
        printlnplus(10)
        delayPrint("THE WIZARD " + wiz.Name.uppercase() + " HAS FALLEN",100)
        delayPrint("...",1000)
        printlnplus(2)
        delayPrint("Statistics", 20)
        delay(300)
        delayPrint("\nWizard Type: \t\t\t\t" + wiz.WizardType, 20)
        delayPrint("\nMax HP: \t\t\t\t" + wiz.MaxHp, 20)
        delayPrint("\nMax Mana: \t\t\t\t" + wiz.MaxMana, 20)
        delayPrint("\nHealth potions left: \t" + wiz.HealthPod, 20)
        delayPrint("\nMana potions left: \t\t" + wiz.ManaPod, 20)
        delayPrint("\nLifesteal potency: \t\t" + wiz.LifeSteal, 20)
        delayPrint("\nKills: \t\t\t\t\t" + wiz.Kills, 20)
        delay(1000)
        printlnplus(2)
        delayPrint("RESTARTING GAME, PLEASE WAIT FOR 10 DOTS",30)
        delayPrint("..........",2000)
        printlnplus(20)
    }


    fun delay(delay: Long){
        Thread.sleep(delay)
    }

    fun delayPrint(Word: String, delay: Long){
        for(i in 0..<Word.length){
            print(Word[i])
            delay(delay)
        }
    }

    fun printlnplus(Lines : Int){
        for (i in 1..Lines){
            println()
        }
    }

    val X = 33 //Amount of lines

    fun printLines(){
        for (i in 1..X) {
            print("-")
        }
        println()
    }

    fun printCenter(Word: String){
        var Final = ""
        var TempSpaces = (X - Word.length) / 2
        if (TempSpaces<1){
            TempSpaces = 0
        }
        for (i in 1..TempSpaces) {
            Final = Final + "-"
        }
        Final = Final + Word
        for (i in 1..TempSpaces) {
            Final = Final + "-"
        }
        println(Final)
    }
}