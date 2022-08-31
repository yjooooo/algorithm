class Solution {
    fun solution(arr: IntArray): IntArray {
        val stack = Stack<Int>()
        stack.push(arr[0])
        for (num in arr) {
            if (stack.peek() != num) {
                stack.push(num)
            }
        }
        return stack.toIntArray()
    }
}