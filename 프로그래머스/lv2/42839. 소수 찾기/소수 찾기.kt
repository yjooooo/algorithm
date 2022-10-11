class Solution {
    lateinit var set: MutableSet<Int>

    fun solution(numbers: String): Int {
        set = mutableSetOf()
        combination(numbers, "")
        return set.count { isPrime(it) }
    }

    // 이 부분은 서치했습니다. 출처 : https://deep-dive-dev.tistory.com/76
    private fun combination(numbers: String, result: String) {
        if (result.isNotEmpty()) {
            set.add(result.toInt())
        }
        if (numbers.isEmpty()) {
            return
        }
        numbers.forEachIndexed { index, c ->
            combination(
                numbers = numbers.removeRange(index..index),
                result = c.plus(result)
            )
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number == 1 || number == 0) {
            return false
        }
        for (i in (2..(number / 2))) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

}