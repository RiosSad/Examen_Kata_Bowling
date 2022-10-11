var Points = 0
fun main() {

    var Tiros = 21
    var Cont = 0
    var Tiro = 0
    var Conjunto = false
    val Valores = mutableListOf<Int>()


    fun SumaDePuntos(numeros: MutableList<Int>): Int {
        var pos = 0
        while (pos < numeros.size) {
            if (pos == numeros.size - 1) {
                if (numeros.get(pos) == 10) {
                    Points += 10
                }
                pos++
            } else if (pos < numeros.size && numeros.get(pos) == 10) {
                Strike(pos, numeros)
                pos++
            } else if (pos < numeros.size && (numeros.get(pos) + numeros.get(pos + 1)) < 10) {
                Open(pos, numeros)
                pos += 2
            } else if (pos < numeros.size && (numeros.get(pos) + numeros.get(pos + 1)) == 10) {
                Spare(pos, numeros)
                pos += 2
            }
        }
        return Points
    }

    while (Tiros > 0) {
        Tiro = readLine()!!.toInt()
        if (Conjunto == false) {
            if (Tiro == 10 && Tiro >= 0) {
                Valores.add(Tiro)
                Tiros -= 2
            } else if (Tiro < 10 && Tiro >= 0) {
                Conjunto = true
                Cont = Tiro
                Valores.add(Tiro)
                Tiros--
            }
        } else {
            if (Tiro + Cont == 10 || Tiro + Cont < 10) {
                Valores.add(Tiro)
                Conjunto = false
                Tiros--
            }
        }

    }
    println("Puntos Optenidos: " + SumaDePuntos(Valores))
}

fun Spare(pos: Int, numeros: MutableList<Int>) {
    Points += numeros.get(pos) + numeros.get(pos + 1) + numeros.get(pos + 2)
}

fun Open(pos: Int, numeros: MutableList<Int>) {
    Points += numeros.get(pos) + numeros.get(pos + 1)
}

fun Strike(pos: Int, numeros: MutableList<Int>) {
    if (pos + 2 < numeros.size) {
        Points += numeros.get(pos) + numeros.get(pos + 1) + numeros.get(pos + 2)
    } else if (pos + 1 == numeros.size - 1) {
        Points += numeros.get(pos) + numeros.get(pos + 1)
    }
}






