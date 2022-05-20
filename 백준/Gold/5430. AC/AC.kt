import MethodName.Companion.DELETE
import MethodName.Companion.ERROR
import MethodName.Companion.REVERSE
import java.lang.IllegalArgumentException

fun main() {
    val n = readLine()!!.toInt()
    val answer = arrayListOf<String>()
    for (i in 0 until n) {
        val methodName = readLine()!!.toString()
        val arrSize = readLine()!!.toInt()
        var arr = readLine()!!.removePrefix("[").removeSuffix("]").split(",").toMutableList()
        var isError = false
        var isReversed = false

        for (j in methodName.indices) {
            when (methodName[j]) {
                REVERSE -> {
                    isReversed = !isReversed
                }
                DELETE -> {
                    if (arr.isEmpty() || arrSize == 0) {
                        isError = true
                    } else {
                        when (isReversed) {
                            true -> arr.removeLast()
                            false -> arr.removeFirst()
                        }
                    }
                }
                else -> {
                    throw IllegalArgumentException()
                }
            }
        }

        if (isError) {
            answer.add(ERROR)
        } else {
            answer.add(
                when (isReversed) {
                    true -> "[${arr.reversed().joinToString(",")}]"
                    false -> "[${arr.joinToString(",")}]"
                }
            )
        }
    }

    answer.forEach { println(it) }
}

class MethodName {
    companion object {
        const val REVERSE = 'R'
        const val DELETE = 'D'
        const val ERROR = "error"
    }
}