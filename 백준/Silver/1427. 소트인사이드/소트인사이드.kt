fun main() {
    val n = readLine()!!.split("")
    val answer = StringBuilder()
    n.sorted().forEach { answer.append(it) }
    print(answer.reversed())
}