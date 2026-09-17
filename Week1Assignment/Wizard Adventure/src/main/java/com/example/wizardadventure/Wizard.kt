package com.example.lib

class Wizard(var Name: String) {
    val print = Print()
    var Hp = 50
    var MaxHp = 50
    var Mana = 30
    var MaxMana = 30
    var Kills = 0
    var ManaPod = 5
    var HealthPod = 5
    var Damage = 10
    var WizardType = "Weak"
    var LifeSteal = 0

    fun Heal (HoM: String ){
        if (HoM.equals("H")){
            print.delayPrint("you attempt to drink a health potion", 30)
            print.delay(1000)
            println()
            if (HealthPod != 0){
                if (Hp == MaxHp){
                    print.delayPrint("You are already at full health", 30)
                    print.delay(1000)
                    println()
                } else{
                    var AmountHealed = Hp
                    Hp = Hp + 25
                    if (Hp > MaxHp){
                        Hp = MaxHp
                    }
                    AmountHealed = Hp - AmountHealed
                    HealthPod--
                    print.delayPrint("You drank the potion and healed " + AmountHealed.toString() + " Hp", 30)
                    print.delay(1000)
                    println()
                }
            } else {
                print.delayPrint("You ran out of health potions", 30)
                print.delay(1000)
                println()
            }
        } else if (HoM.equals("M")){
            print.delayPrint("you attempt to drink a mana potion", 30)
            print.delay(1000)
            println()
            if (ManaPod != 0){
                if (Mana == MaxMana){
                    print.delayPrint("You are already at full mana", 30)
                    print.delay(1000)
                    println()
                } else {
                    var AmountRestored = Mana
                    Mana = Mana + 15
                    if (Mana > MaxMana){
                        Mana = MaxMana
                    }
                    AmountRestored = Mana - AmountRestored
                    ManaPod--
                    print.delayPrint("You drank the potion and restored " + AmountRestored.toString() + " Mp", 30)
                    print.delay(1000)
                    println()
                }
            } else {
                print.delayPrint("You ran out of mana potions", 30)
                print.delay(1000)
                println()
            }
        } else {
            print ("error in Wizard. Function Heal")
        }
    }

    fun TakeDamage(Damage: Int){
        var DamageTaken = Damage
        print.delayPrint("You are being attacked", 30)
        print.delay(1000)
        println()
        Hp = Hp - DamageTaken
        if (Hp < 0){
            Hp = 0
        }
        if (Hp == 0){
            DamageTaken = DamageTaken - Hp
            print.delayPrint("You took " + DamageTaken + " damage and have died",30)
        } else {
            print.delayPrint("You took " + DamageTaken + " damage", 30)
        }
        print.delay(1000)
        println()
    }

    fun evolve(){
        if (WizardType.equals("Weak") && Kills == 5) {
            MaxHp = (MaxHp * 1.5).toInt()
            MaxMana = (MaxMana * 1.5).toInt()
            Damage = (Damage * 1.5).toInt()
            Hp = MaxHp
            Mana = MaxMana
            WizardType = "Strong"
            print.delayPrint("Wizard has evolved to Strong Wizard", 30)
            print.delay(1000)
            print.delayPrint("\nWizard Learned Lifesteal" + LifeSteal.toString(), 30)
            print.delay(800)
            print.printlnplus(2)
        }
        if (WizardType.equals("Strong")){
            LifeSteal++
            print.delayPrint("Your Lifesteal Grows Stronger", 30)
            print.delay(1000)
            print.delayPrint("\nLifesteal lvl: " + LifeSteal.toString(), 30)
            print.delay(800)
            println()
        }
    }

    fun LifeSteal(Heal: Int){
        var Drain = Heal
        if (LifeSteal < Heal){
            Drain = LifeSteal
        }
        var AmountDrainned = Hp
        Hp = Hp + Drain
        if (Hp > MaxHp){
            Hp = MaxHp
        }
        AmountDrainned = Hp - AmountDrainned
        if (AmountDrainned != 0){
            print.delayPrint("You drainned "+ AmountDrainned.toString() + " HP with lifesteal", 30)
        }
    }
}