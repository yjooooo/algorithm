class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = money.toLong()
        for(i in 1.. count){ answer -= price*i}
        return if(answer < 0) -answer else 0
    }
}