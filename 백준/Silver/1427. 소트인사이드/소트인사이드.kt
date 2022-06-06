fun main() {
    val n = readLine()!!.split("")
    n.sortedDescending().forEach { print(it) }
}