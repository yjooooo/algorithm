class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var x = 0
        var y = 0
        for (square in sizes) {
            with(square.sorted()) {
                if (x < this[0]) x = this[0]
                if (y < this[1]) y = this[1]
            }
        }
        return x * y
    }
}