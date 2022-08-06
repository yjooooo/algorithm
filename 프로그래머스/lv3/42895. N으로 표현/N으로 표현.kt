import kotlin.math.min
import kotlin.math.pow

class Solution {
    var answer = 9
    var target = 0

    fun solution(N: Int, number: Int): Int {
        target = number
        countN(N, 0, 0)
        if (answer == 9) {
            return -1
        }
        return answer
    }

    private fun countN(n: Int, count: Int, current: Int) {
        if (count > 8) {
            return
        }
        if (current == target) {
            answer = min(answer, count)
            return
        }
        var tempNum = n
        for (i in 0 until 8 - count) {
            countN(n, count + 1 + i, current + tempNum)
            countN(n, count + 1 + i, current - tempNum)
            countN(n, count + 1 + i, current * tempNum)
            countN(n, count + 1 + i, current / tempNum)
            tempNum += n * 10f.pow(i + 1).toInt()
        }
    }
}