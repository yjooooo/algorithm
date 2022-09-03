class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val checkedList = mutableListOf<Int>()

        for (i in 0 until n) {
            if (!checkedList.contains(i)) {
                checkNetwork(i, computers, checkedList)
                answer++
            }
        }

        return answer
    }

    private fun checkNetwork(idx: Int, computers: Array<IntArray>, checkedList: MutableList<Int>) {
        checkedList.add(idx)
        computers[idx].forEachIndexed { index, connected ->
            if (connected == 1 && !checkedList.contains(index)) {
                checkNetwork(index, computers, checkedList)
            }
        }
    }
}