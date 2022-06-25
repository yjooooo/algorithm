fun main() {
    val n = readLine()!!.toInt()
    val answer = StringBuilder()
    val arr = ArrayList<Int>()
    for (i in 0 until n) {
        arr.add(readLine()!!.toInt())
    }
    arr.sort()
    for (i in 0 until n) {
        answer.append("${arr[i]}\n")
    }
    println(answer)
}
