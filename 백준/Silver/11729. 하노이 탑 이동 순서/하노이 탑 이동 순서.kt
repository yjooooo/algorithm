import java.lang.StringBuilder

fun main() {
    val n = readLine()!!.toInt()
    var count = 0
    var route = StringBuilder()
    fun hanoi(n: Int, from: Int, to: Int, sub: Int) {
        count++
        if (n == 1) {
            route.append("$from $to\n")
        } else {
            hanoi(n - 1, from, sub, to)
            route.append("$from $to\n")
            hanoi(n - 1, sub, to, from)
        }
    }

    hanoi(n, 1, 3, 2)
    println(count)
    println(route)
}
