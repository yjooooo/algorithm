class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        val numToList = number.split("").toMutableList().apply {
            removeFirst()
            removeLast()
        }
        val answerLength = number.length - k
        var remainLength = answerLength
        var startIdx = 0

        while (answer.length != answerLength) {
            val lastIdx = numToList.size - remainLength + 1
            var max = 0
            var maxIdx = 0
            // max 찾을 때 for문으로 직접 찾아야 시간초과 X
            // maxOrNull() 사용 시 시간초과 발생
            for (i in startIdx until lastIdx) {
                val curNum = numToList[i].toInt()
                if (curNum > max) {
                    max = curNum
                    maxIdx = i - startIdx
                    if (curNum == 9) break
                }
            }
            answer += max
            startIdx += maxIdx + 1
            remainLength--
        }

        return answer
    }
}