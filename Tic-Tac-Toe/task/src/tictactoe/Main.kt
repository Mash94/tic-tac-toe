package tictactoe

import java.util.*;

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    //print("Enter cells: ")
    //var i: String = scanner.nextLine()
    var i: String = "_________"
    var pos: Int
    var car: Char = 'X'
    var wins = 1

    while(wins >= 0) {
        pos = -1
        while (pos < 0) {
            print("Enter the coordinates: ")
            var coordinates = IntArray(2) { scanner.nextInt() }
            //println("${coordinates[0]} ${coordinates[1]}")

            when (coordinates[0]) {
                1 -> pos = 0
                2 -> pos = 3
                3 -> pos = 6
                else -> {
                    println("Coordinates should be from 1 to 3!")
                    pos = -1
                }
            }
            if (pos >= 0) {
                when (coordinates[1]) {
                    1 -> pos += 0
                    2 -> pos += 1
                    3 -> pos += 2
                    else -> {
                        println("Coordinates should be from 1 to 3!")
                        pos = -1
                    }
                }
            }

            if ((pos >= 0) && (i.get(pos) == 'X' || i.get(pos) == 'O')) {
                println("This cell is occupied! Choose another one!")
                pos = -1
            }

            if (pos >= 0) {
                i = modifyTable(car, pos, i)
                if(car == 'X') car = 'O'
                else car = 'X'
            }
            wins = checkForWin(i)
        }
    }
}

fun printTable(tabla: String){
    var i = tabla.replace('_',' ')
    println("---------")
    println("| ${i[0]} ${i[1]} ${i[2]} |")
    println("| ${i[3]} ${i[4]} ${i[5]} |")
    println("| ${i[6]} ${i[7]} ${i[8]} |")
    println("---------")
}

fun modifyTable(car: Char, pos: Int, tabla: String): String {
    var chars: CharArray = tabla.toCharArray()
    var i : String
    chars[pos] = car
    i = String(chars)
    printTable(i)
    return i
}

fun checkForWin(i: String): Int{
    var legend = ""
    var cont = 0
    var xcont = 0
    var ocont = 0
    var wins : Int = 0

    for(t in i){
        if(t == '_') cont++
        if(t == 'X') xcont++
        if(t == 'O') ocont++
    }
    if(cont >= 3) legend = "Game not finished"
    if(xcont > ocont+1) legend = "Impossible"
    if(ocont > xcont+1) legend = "Impossible"

    //print(legend)

    if((i[0]=='X') && (i[1]=='X') && (i[2]=='X')) {
        legend = "X wins"
        wins++
    }
    else if((i[3]=='X') && (i[4]=='X') && (i[5]=='X')) {
        legend = "X wins"
        wins++
    }
    if((i[6]=='X') && (i[7]=='X') && (i[8]=='X')) {
        legend = "X wins"
        wins++
    }

    if((i[0]=='X') && (i[3]=='X') && (i[6]=='X')) {
        legend = "X wins"
        wins++
    }
    if((i[1]=='X') && (i[4]=='X') && (i[7]=='X')) {
        legend = "X wins"
        wins++
    }
    if((i[2]=='X') && (i[5]=='X') && (i[8]=='X')) {
        legend = "X wins"
        wins++
    }

    if((i[0]=='X') && (i[4]=='X') && (i[8]=='X')) {
        legend = "X wins"
        wins++
    }
    if((i[6]=='X') && (i[4]=='X') && (i[2]=='X')) {
        legend = "X wins"
        wins++
    }

    if((i[0]=='O') && (i[1]=='O') && (i[2]=='O')) {
        legend = "O wins"
        wins++
    }
    if((i[3]=='O') && (i[4]=='O') && (i[5]=='O')) {
        legend = "O wins"
        wins++
    }
    if((i[6]=='O') && (i[7]=='O') && (i[8]=='O')) {
        legend = "O wins"
        wins++
    }

    if((i[0]=='O') && (i[3]=='O') && (i[6]=='O')) {
        legend = "O wins"
        wins++
    }
    if((i[1]=='O') && (i[4]=='O') && (i[7]=='O')) {
        legend = "O wins"
        wins++
    }
    if((i[2]=='O') && (i[5]=='O') && (i[8]=='O')) {
        legend = "O wins"
        wins++
    }

    if((i[0]=='O') && (i[4]=='O') && (i[8]=='O')) {
        legend = "O wins"
        wins++
    }
    if((i[2]=='O') && (i[4]=='O') && (i[6]=='O')) {
        legend = "O wins"
        wins++
    }

    if((legend != "Game not finished") && (legend != "Impossible") && (wins == 0)) legend = "Draw"

    if(wins > 1) legend = "Impossible"

    println("${legend}")
    if(legend == "O wins" || legend == "X wins" || cont == 0) return -1
    //if(legend == "O wins" || legend == "X wins") return -1
    else return 0
}

