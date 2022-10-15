class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        for (yellowH in 1..(yellow / 2) + 1) {
            if(yellow % yellowH == 0){
                val yellowW = yellow / yellowH
                if (yellowH <= yellowW && ((yellowW + 2) * (yellowH + 2) == brown + yellow)) {
                    answer += yellowW + 2
                    answer += yellowH + 2
                }
            }
        }
        return answer
    }
}