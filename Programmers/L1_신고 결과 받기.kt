class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size) { 0 }
        val reporterList = MutableList(id_list.size) { mutableListOf<Int>() }
        val countArr = IntArray(id_list.size) { 0 }

        for (item in report) {
            val reporterIdx = id_list.indexOf(item.split(" ")[0])
            val whoIdx = id_list.indexOf(item.split(" ")[1])
            if(!reporterList[whoIdx].contains(reporterIdx)){
                reporterList[whoIdx].add(reporterIdx)
                countArr[whoIdx] += 1
            }
        }

        for ((index, count) in countArr.withIndex()) {
            if (count >= k) {
                for (reporterInx in reporterList[index]) {
                    answer[reporterInx] += 1
                }
            }
        }

        return answer
    }
}
