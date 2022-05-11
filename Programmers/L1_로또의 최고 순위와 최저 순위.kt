class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var min = 0
        var max = 0
        var countZero = 0
        var countCorrect = 0
        lottos.forEach {
            if (it == 0) {
                countZero++
            }
        }
        win_nums.forEach {
            if (lottos.contains(it)) {
                countCorrect++
            }
        }
        min = when (countCorrect) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
        max = when (countCorrect + countZero) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
        return intArrayOf(max, min)
    }
}
