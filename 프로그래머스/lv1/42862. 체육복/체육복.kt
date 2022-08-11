class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        val students = Array(n) { index -> !lost.contains(index + 1) || reserve.contains(index + 1) }
        val realReserve = reserve.filter { !lost.contains(it) }

        for (i in realReserve.sorted()) {
            val stuNum = i - 1
            if (stuNum - 1 >= 0 && !students[stuNum - 1]) {
                students[stuNum - 1] = true
            } else if (stuNum + 1 <= n - 1 && !students[stuNum + 1]) {
                students[stuNum + 1] = true
            }
        }
        
        answer = students.count { it }

        return answer
    }
}