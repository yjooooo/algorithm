class Solution {
    fun solution(s: String): Int {
        var answer = s.length;

        for (i in 1 until s.length) {
            var result = ""
            var str = ""
            var nextStr = ""
            var count = 1

            // 일정 길이로 잘라서 확인 후 압축 가능하면 압축 후 그 결과를 result 에 더함.
            // 다 더해지면 압축이 끝난 후의 문자열이 보임
            for (j in s.indices step i) {
                str = s.substring(j, j + i)
                nextStr = if (j + 2 * i <= s.length) {
                    s.substring(j + i, j + 2 * i)
                } else {
                    s.substring(j + i)
                }

                if (str.length == nextStr.length) {
                    if (str == nextStr) {
                        count++
                    } else {
                        if (count != 1) result += count
                        result += str
                        count = 1
                    }
                } else {
                    //마지막 종료 지점
                    if (count != 1) {
                        result += count;
                        count = 1
                    }
                    result += (str + nextStr)
                    break;
                }
            }

            answer = Math.min(answer, result.length)
        }

        return if (answer == Integer.MAX_VALUE) 1 else answer
    }
}
