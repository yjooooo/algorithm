import java.lang.StringBuilder

fun main() {
    val n = readLine()!!.toInt()
    val originalX = readLine()!!.split(" ").map { it.toInt() }
    val sortedX = originalX.distinct().sorted()
    val hashX = HashMap<Int, Int>()
    var index = 0
    sortedX.forEach {
        hashX[it] = index++
    }
    val answer = StringBuilder()
    originalX.forEach {
        answer.append("${hashX[it]} ")
    }
    println(answer)
}