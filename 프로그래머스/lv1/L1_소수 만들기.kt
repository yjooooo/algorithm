class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0

        for (first in 0 until nums.size - 2) {
            for (second in first + 1 until nums.size - 1) {
                for (third in second + 1 until nums.size) {
                    var flag = true
                    val sum = nums[first] + nums[second] + nums[third]
                    for (i in 2 until sum) {
                        if (sum % i == 0) {
                            flag = false
                            break
                        }
                    }
                    if (flag) {
                        answer++
                    }
                }
            }
        }

        return answer
    }
}
