class Solution {
    fun solution(triangle: Array<IntArray>): Int {
        var answer = 0
        val temp = Array(triangle.size) { IntArray(triangle.size) }
        temp[0][0] = triangle[0][0]

        for (i in 1 until triangle.size) {
            // 가장 왼쪽
            temp[i][0] = temp[i - 1][0] + triangle[i][0]

            // 중간
            for (j in 1..i) {
                temp[i][j] = triangle[i][j] + maxOf(temp[i - 1][j - 1], temp[i - 1][j])
            }

            // 가장 오른쪽
            temp[i][i] = temp[i - 1][i - 1] + triangle[i][i]
        }

        for (i in triangle.indices) {
            answer = maxOf(answer, temp[triangle.lastIndex][i])
        }

        return answer
    }
}