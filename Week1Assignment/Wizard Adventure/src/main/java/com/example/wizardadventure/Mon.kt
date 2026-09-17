package com.example.lib
import kotlin.random.Random

class Mon(val Name: String, dif: Int) {
    val print = Print()
    val MaxHp = 25 + ((Random.nextInt(0, 3)) * 5) + ((dif / 3) * 5).toInt()
    var Hp = MaxHp
    val Damage = 5 + ((Random.nextInt(0, 8))) + ((dif)).toInt()

    fun TakeDamage(Type: Char, Damage: Int): Int {
        var DamageTaken = Damage
        print.delayPrint("The " + Name + " is taking damage", 30)
        print.delay(1000)
        println()
        if (Type == 'F' && Name[0] == 'G') {
            print.delayPrint("The fire attack was super effective!", 30)
            print.delay(1000)
            println()
            DamageTaken = DamageTaken*2
        }
        if (Type == 'G' && Name[0] == 'W') {
            print.delayPrint("The grass attack was super effective!", 30)
            print.delay(1000)
            println()
            DamageTaken = DamageTaken*2
        }
        if (Type == 'W' && Name[0] == 'F') {
            print.delayPrint("The water attack was super effective!", 30)
            print.delay(1000)
            println()
            DamageTaken = DamageTaken*2
        }
        Hp = Hp - DamageTaken
        if (Hp < 0){
            Hp = 0
        }
        if (Hp == 0){
            DamageTaken = DamageTaken - Hp
            print.delayPrint("The " + Name + " took " + DamageTaken + " damage and has been killed",30)
        } else {
            print.delayPrint("The " + Name + " took " + DamageTaken + " damage", 30)
        }
        print.delay(1000)
        println()
        return DamageTaken
    }
}