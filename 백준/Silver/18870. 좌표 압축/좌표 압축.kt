import java.lang.StringBuilder

fun main() {
    val n = readLine()!!.toInt()
    val originalX = readLine()!!.split(" ").map { it.toInt() }
    val sortedX = originalX.distinct().sorted()
    val answer = StringBuilder()
    originalX.forEach {
        answer.append("${sortedX.binarySearch(it)} ")
    }
    println(answer)
}

/* 방법2
import java.lang.StringBuilder

fun main() {
    val n = readLine()!!.toInt()
    val originalX = readLine()!!.split(" ").map { it.toInt() }
    val sortedX = originalX.distinct().sorted()
    val answer = StringBuilder()
    originalX.forEach {
        answer.append("${sortedX.binarySearch(it)} ")
    }
    println(answer)
}
*/
