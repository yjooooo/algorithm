import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val tempStack = Stack<Char>()

        if (s.length % 2 == 1) return 0

        Loop1@
        for (i in s.indices) {
            val newS = s.substring(i, s.length) + s.substring(0, i)
            Loop2@
            for ((idx, str) in newS.withIndex()) {
                if (idx == 0) {
                    if (str == ')' || str == '}' || str == ']') {
                        continue@Loop1
                    }
                    tempStack.push(str)
                    continue@Loop2
                }
                when (str) {
                    '(', '{', '[' -> tempStack.push(str)
                    ')' -> {
                        if(tempStack.isEmpty()) continue@Loop1
                        if (tempStack.peek() == '(') {
                            tempStack.pop()
                        }
                    }
                    '}' -> {
                        if(tempStack.isEmpty()) continue@Loop1
                        if (tempStack.peek() == '{') {
                            tempStack.pop()
                        }
                    }
                    ']' -> {
                        if(tempStack.isEmpty()) continue@Loop1
                        if (tempStack.peek() == '[') {
                            tempStack.pop()
                        }
                    }
                }
            }
            if (tempStack.size == 0) answer++
            tempStack.clear()
        }
        return answer
    }
}