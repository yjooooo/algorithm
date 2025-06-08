class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        val nodeCount = edges.maxOf { maxOf(it[0], it[1]) } + 1
        val startVertex = IntArray(nodeCount) { 0 }
        val endVertex = IntArray(nodeCount) { 0 }
        val graph = Array<MutableList<Int>>(nodeCount) { mutableListOf() }
        
        for ((start, end) in edges) {
            startVertex[start]++
            endVertex[end]++
            graph[start].add(end)
        }
        
        // 생성한 정점 찾기 : [x, y] x에는 있지만 y에는 없는 숫자
        var newVertex = -1
        for (i in 1 until nodeCount) {
            if (startVertex[i] >= 2 && endVertex[i] == 0) {
                newVertex = i
                break
            }
        }
        
        var donutCount = 0
        var lineCount = 0
        var eightCount = 0
        // println("graph: ${graph.contentToString()}")
        for (node in graph[newVertex]) {
            val path = mutableSetOf<Int>()
                var curNode = node
                while (true) {
                    // println("curNode: $curNode, path: $path, graph[curNode]: ${graph[curNode]}")
                    if (curNode in path) {
                        // 도넛
                        donutCount++
                        break
                    }
                    path.add(curNode)
                    
                    if (graph[curNode].isEmpty()) {
                        // 막대
                        lineCount++
                        break
                    } else if (graph[curNode].size >= 2) {
                        // 8자
                        eightCount++
                        break
                    }
                    curNode = graph[curNode][0]
                }
        }
           
        
        return intArrayOf(newVertex, donutCount, lineCount, eightCount)
    }
}
