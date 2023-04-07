class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = players
        val indexMap = mutableMapOf<String, Int>()
        for (i in answer.indices) {
            indexMap[answer[i]] = i
        }
        for (i in callings.indices) {
            val index = indexMap[callings[i]]!!
            indexMap[players[index]] = index - 1
            indexMap[players[index-1]] = index
            val tmp = players[index]
            players[index] = players[index - 1]
            players[index - 1] = tmp
        }
        return answer
    }
}