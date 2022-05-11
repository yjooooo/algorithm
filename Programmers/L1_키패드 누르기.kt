class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var l = 10
        var r = 12
        numbers.map {
            if (it == 0) {
                11
            } else {
                it
            }
        }.forEach {
            when (it) {
                1, 4, 7 -> {
                    answer += "L"
                    l = it
                }
                3, 6, 9 -> {
                    answer += "R"
                    r = it
                }
                else -> {
                    val lengthL = getLength(l, it)
                    val lengthR = getLength(r, it)
                    if (lengthL < lengthR) {
                        answer += "L"
                        l = it
                    } else if (lengthL > lengthR) {
                        answer += "R"
                        r = it
                    } else {
                        when (hand) {
                            "left" -> {
                                answer += "L"
                                l = it
                            }
                            else -> {
                                answer += "R"
                                r = it
                            }
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun getLength(oldLocation: Int, newLocation: Int) = when (oldLocation) {
        2, 5, 8, 11 -> {
            (newLocation - oldLocation).absoluteValue / 3
        }
        else -> {
            when ((newLocation - oldLocation).absoluteValue) {
                3 -> 1
                4 -> 2
                5, 7 -> 3
                8, 10 -> 4
                else -> (newLocation - oldLocation).absoluteValue
            }
        }
    }
}
