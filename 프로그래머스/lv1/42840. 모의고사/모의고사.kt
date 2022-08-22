class Solution {
    fun solution(answers: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val scores = intArrayOf(0, 0, 0)

        for ((i, ans) in answers.withIndex()) {
            if (ans == a[i % a.size]) scores[0]++
            if (ans == b[i % b.size]) scores[1]++
            if (ans == c[i % c.size]) scores[2]++
        }

        var max = scores[0]
        answer.add(1)
        for (i in 1 until scores.size) {
            if (max <= scores[i]) {
                if (max < scores[i]) {
                    max = scores[i]
                    answer.clear()
                }
                answer.add(i + 1)
            }
        }

        return answer.toIntArray()
    }

    companion object {
        val a = listOf(1, 2, 3, 4, 5)
        val b = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val c = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    }
}