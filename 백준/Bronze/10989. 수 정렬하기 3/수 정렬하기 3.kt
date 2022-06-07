fun main() {
    val n = readLine()!!.toInt()
    val answer = StringBuilder()
    val arr = IntArray(10001)
    for (i in 0 until n) {
        arr[readLine()!!.toInt()]++
    }
    for (i in arr.indices) {
        for (j in 0 until arr[i]) {
            answer.append(i).append("\n")
        }
    }
    println(answer)
}