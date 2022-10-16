class Solution {
    // 크루스칼 알고리즘 (최소 신장 트리 구하기)
    private val parents = ArrayList<Int>()

    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        // 비용의 오름차순으로 간선 정렬
        val sortedCosts = costs.copyOf().apply { sortWith(compareBy({ it[2] }, { it[0] })) }
        // 정점의 parents 배열 초기화 (초기 상태는 parent = 정점 자기 자신)
        for (i in 0 until n) {
            parents.add(i)
        }
        // 초기 간선 개수 0
        var edgeCount = 0
        for (c in sortedCosts) {
            if (union(c[0], c[1])) {
                answer += c[2]
                edgeCount++
            }
            // 간선의 개수 == 정점개수 - 1 일 때 종료
            if (edgeCount == n - 1) {
                break
            }
        }

        return answer
    }

    // parent 정보 return
    private fun find(vertex: Int) = parents[vertex]

    // parent 가 다르다면 간선을 추가하고 parent 업데이트 후 return true
    // parent 가 같다면 간선을 이을 경우 사이클이 생기므로 바로 return false
    private fun union(vertex1: Int, vertex2: Int): Boolean =
        if (find(vertex1) == find(vertex2)) {
            false
        } else {
            if (find(vertex1) > find(vertex2)) {
                updateOthers(parents[vertex1], parents[vertex2])
                parents[vertex1] = parents[vertex2]
            } else {
                updateOthers(parents[vertex2], parents[vertex1])
                parents[vertex2] = parents[vertex1]
            }
            true
        }

    // 현재 parent 업데이트 된다면 현재 parent 값과 같은 parent 를 갖고 있는 정점들도 업데이트 해줘야 함
    private fun updateOthers(oldParent: Int, newParent: Int) {
        for (i in parents.indices) {
            if (parents[i] == oldParent) {
                parents[i] = newParent
            }
        }
    }
}
