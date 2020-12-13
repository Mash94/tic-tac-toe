import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    var pos = 0
    //var i: String = "OOOOOOOOOOOOOOOOOOOOOOOOO"
    var i: String = "                         "
    var filaLibre = mutableListOf<Int>(1,2,3,4,5)
    var columnaLibre = mutableListOf<Int>(1,2,3,4,5)
    // put your code here

    var cell1 = IntArray(2) {input.nextInt()}
    var cell2 = IntArray(2){input.nextInt()}
    var cell3 = IntArray(2){input.nextInt()}

    /*
    pos = findPos(pos, cell1[0], cell1[1])
    i = modifyTable('X', pos, i)
    pos = findPos(pos, cell2[0], cell2[1])
    i = modifyTable('Y', pos, i)
    pos = findPos(pos, cell3[0], cell3[1])
    i = modifyTable('T', pos, i)
    //printTable(i)
    */
    filaLibre.remove(cell1[0])
    filaLibre.remove(cell2[0])
    filaLibre.remove(cell3[0])

    columnaLibre.remove(cell1[1])
    columnaLibre.remove(cell2[1])
    columnaLibre.remove(cell3[1])

    for(i in 0..((filaLibre.lastIndex)-1))
        print("${filaLibre[i]} ")
    print("${filaLibre[filaLibre.lastIndex]}")
    print('\n')
    for(i in 0..((columnaLibre.lastIndex)-1))
        print("${columnaLibre[i]} ")
    print("${columnaLibre[columnaLibre.lastIndex]}")

}

fun printTable(table: String){
    var lim = -1
    println("   1 2 3 4 5  ")
    println(" -------------")
    for(k in 0..4) {
        print("${k+1}| ")
        for (j in (lim+1)..(lim+5)) {
            print("${table[j]} ")
            lim = j
        }
        println("|")
    }
    println(" -------------")
}

fun modifyTable(car: Char, pos: Int, tabla: String): String {
    var chars: CharArray = tabla.toCharArray()
    var i : String
    chars[pos] = car
    i = String(chars)
    //printTable(i)
    return i
}

fun findPos(pos: Int, x: Int, y: Int): Int{
    //println("ROW    $x is occuped")
    //println("COLUMN $y is occuped")
    var npos = pos
    when (x) {
        1 -> npos = 0
        2 -> npos = 5
        3 -> npos = 10
        4 -> npos = 15
        5 -> npos = 20
        else -> {
            println("Coordinates should be from 1 to 5!")
            npos = -1
        }
    }
    if (npos >= 0) {
        when (y) {
            1 -> npos += 0
            2 -> npos += 1
            3 -> npos += 2
            4 -> npos += 3
            5 -> npos += 4
            else -> {
                println("Coordinates should be from 1 to 5!")
                npos = -1
            }
        }
    }
    return npos
}