import java.util.LinkedList

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var current = location
        val waitQueue = LinkedList<Int>().apply { addAll(priorities.toList()) }
        var maxReq = waitQueue.maxOrNull()

        while (waitQueue.isNotEmpty()) {
            if (waitQueue.peek() == maxReq) {
                waitQueue.poll()
                maxReq = waitQueue.maxOrNull()
                answer++
                if (0 == current) {
                    break
                }
            } else {
                waitQueue.add(waitQueue.poll())
            }
            if (0 == current) {
                current = waitQueue.size - 1
            } else {
                current--
            }
        }

        return answer
    }
}