fun main() {
    val n = readLine()!!.toInt()
    val arr = ArrayList<Pair<Int, String>>()
    for (i in 0 until n) {
        val info = readLine()!!.split(" ")
        arr.add(Pair(info[0].toInt(), info[1]))
    }
    for (info in arr.sortedWith(compareBy { info -> info.first })) {
        println("${info.first} ${info.second}")
    }
}