class Solution {
    fun solution(a: IntArray, b: IntArray): Int =
        a.foldIndexed(0) { index, total, aNum -> total + (aNum * b[index]) }
}
