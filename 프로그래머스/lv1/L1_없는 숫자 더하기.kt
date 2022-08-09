class Solution {
    fun solution(numbers: IntArray) = (0..9).map {
        if (numbers.contains(it)) {
            0
        } else {
            it
        }
    }.sum()
}
