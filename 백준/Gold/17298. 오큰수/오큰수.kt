fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val answer = Array(arr.size) { -1 }
    val stack = arrayListOf<Int>()

    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && arr[i] >= stack.last()) {
            stack.removeLast()
        }
        if (stack.isNotEmpty()) {
            answer[i] = stack.last()
        } else {
            answer[i] = -1
        }
        stack.add(arr[i])
    }
    println(answer.joinToString(" "))
}
