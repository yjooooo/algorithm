class Solution {
    fun solution(numbers: IntArray): String {
        var answer = numbers.sortedWith { num1, num2 ->
            "$num1$num2".compareTo("$num2$num1")
        }.reversed().joinToString("")
        if (answer[0] == '0') {
            answer = answer.toInt().toString()
        }
        return answer
    }
}