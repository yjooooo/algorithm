fun main() {
    val n = readLine()!!.toInt()
    val dots = ArrayList<Pair<Int, Int>>()
    for (i in 0 until n) {
        val dot = readLine()!!.split(" ")
        dots.add(Pair(dot[0].toInt(), dot[1].toInt()))
    }
    dots.sortedWith(compareBy(
        { dot -> dot.first },
        { dot -> dot.second }
    )).forEach { dot ->
        println("${dot.first} ${dot.second}")
    }
}