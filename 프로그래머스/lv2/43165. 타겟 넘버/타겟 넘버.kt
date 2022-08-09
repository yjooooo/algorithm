class Solution {
    var count = 0
    fun solution(numbers: IntArray, target: Int): Int {
        calculate(0, numbers, target, 0)
        return count
    }

    private fun calculate(result: Int, numbers: IntArray, target: Int, depth: Int) {
        if (depth == numbers.size) {
            if (result == target) {
                count++
            }
        } else {
            val addResult = result + numbers[depth]
            val subResult = result - numbers[depth]
            calculate(addResult, numbers, target, depth + 1)
            calculate(subResult, numbers, target, depth + 1)
        }
    }
}