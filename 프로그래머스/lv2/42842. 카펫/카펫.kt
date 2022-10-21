import kotlin.math.sqrt

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        for (yellowH in 1..sqrt(yellow.toFloat()).toInt()) {
            if(yellow % yellowH == 0){
                val yellowW = yellow / yellowH
                if ((yellowW + 2) * (yellowH + 2) == brown + yellow) {
                    answer += yellowW + 2
                    answer += yellowH + 2
                }
            }
        }
        return answer
    }
}