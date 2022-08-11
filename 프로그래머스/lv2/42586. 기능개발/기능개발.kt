class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val tasks = progresses.toMutableList()
        var speedIdx = 0

        while (tasks.size > 0) {
            val doneTasks = mutableListOf(-1)
            for ((i, task) in tasks.withIndex()) {
                tasks[i] = task + speeds[i + speedIdx]
                if (tasks[i] >= 100 && doneTasks.last() == i - 1) {
                    doneTasks.add(i)
                }
            }
            if (doneTasks.size > 1) {
                for (i in doneTasks.indices - 1) {
                    tasks.removeAt(0)
                    speedIdx += 1
                }
                answer += doneTasks.size - 1
            }
        }

        return answer
    }
}