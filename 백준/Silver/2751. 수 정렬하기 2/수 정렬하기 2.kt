import kotlin.collections.ArrayList

fun main() {
    val n = readLine()!!.toInt()
    val answer = StringBuilder()
    val arr = ArrayList<Int>()
    for (i in 0 until n) {
        arr.add(readLine()!!.toInt())
    }
    arr.sort().apply {
        for(i in arr.indices){
            answer.append(arr[i]).append("\n")
        }
    }
    println(answer)
}