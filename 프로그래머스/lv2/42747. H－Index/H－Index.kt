class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        val size = citations.size
        val sortedCit = citations.sorted()
        for ((index, citation) in sortedCit.withIndex()) {
            val upCount = size - (index + 1) + 1
            if (citation > upCount) {
                while(upCount -1 >= answer){
                    answer++
                }
                break
            }
            answer = citation
        }
        return answer
    }
}