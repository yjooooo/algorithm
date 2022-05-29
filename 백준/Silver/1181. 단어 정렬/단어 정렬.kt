fun main() {
    val n = readLine()!!.toInt()
    val arr = mutableSetOf<String>()
    for (i in 0 until n) {
        arr.add(readLine()!!)
    }
    arr.sortedWith(compareBy(
        { word -> word.length },
        { word -> word }
    )).forEach { println(it) }
}