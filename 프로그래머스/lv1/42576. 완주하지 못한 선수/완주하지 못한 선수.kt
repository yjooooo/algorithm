class Solution {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        var answer: String = ""
        val incompleteMap = HashMap<String, Int>()
        for (p in participant) {
            incompleteMap[p] = incompleteMap.getOrDefault(p, 0) + 1
        }
        for (c in completion) {
            incompleteMap[c] = requireNotNull(incompleteMap[c]) - 1
        }
        for (p in participant) {
            if (incompleteMap[p] == 1) {
                answer = p
                break
            }
        }

        return answer
    }
}
