class Solution {
    fun solution(nums: IntArray): Int {
        val maxCount = nums.size / 2
        val typeCount = nums.distinct().size
        return if (typeCount < maxCount) typeCount else maxCount
    }
}
