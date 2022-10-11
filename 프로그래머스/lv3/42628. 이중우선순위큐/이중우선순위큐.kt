import java.util.PriorityQueue

class Solution1 {
    fun solution(operations: Array<String>): IntArray {
        val pq = PriorityQueue<Int>()
        for (o in operations) {
            if (o.startsWith(INSERT)) {
                pq.add(o.removePrefix(INSERT).toInt())
            } else if (o.startsWith(DELETE_MAX)) {
                if (pq.isEmpty()) {
                    continue
                }
                pq.remove(pq.maxOrNull())
            } else if (o.startsWith(DELETE_MIN)) {
                if (pq.isEmpty()) {
                    continue
                }
                pq.poll()
            }
        }

        return if (pq.isNotEmpty()) {
            intArrayOf(requireNotNull(pq.maxOrNull()), pq.peek())
        } else {
            intArrayOf(0, 0)
        }
    }

    companion object {
        const val INSERT = "I "
        const val DELETE_MAX = "D 1"
        const val DELETE_MIN = "D -1"
    }
}


// 제목대로 우선순위큐를 2개 만들어서 푸는 방법도 있네여!
class Solution2 {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)
        val minPq = PriorityQueue<Int>()
        val maxPq = PriorityQueue<Int>(reverseOrder())
        for (o in operations) {
            if (o.startsWith(INSERT)) {
                minPq.add(o.removePrefix(INSERT).toInt())
                maxPq.add(o.removePrefix(INSERT).toInt())
            } else if (o.startsWith(DELETE_MAX)) {
                if (maxPq.isEmpty()) {
                    continue
                }
                val max = maxPq.poll()
                minPq.remove(max)
            } else if (o.startsWith(DELETE_MIN)) {
                if (minPq.isEmpty()) {
                    continue
                }
                val min = minPq.poll()
                maxPq.remove(min)
            }
        }

        if (minPq.isNotEmpty()) {
            answer = intArrayOf(maxPq.peek(), minPq.peek())
        }

        return answer
    }

    companion object {
        const val INSERT = "I "
        const val DELETE_MAX = "D 1"
        const val DELETE_MIN = "D -1"
    }
}
