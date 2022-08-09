import java.util.PriorityQueue

class Solution {
    fun solution(scoville: IntArray, K: Int): Int {
        var answer = 0
        val newScoville = PriorityQueue<Int>()

        for (n in scoville) {
            newScoville.add(n)
        }

        while (newScoville.peek() <= K) {
            if (newScoville.size == 1) {
                return -1;
            }
            answer++
            val new = newScoville.poll() + newScoville.poll() * 2
            newScoville.add(new)
        }

        return answer
    }
}

