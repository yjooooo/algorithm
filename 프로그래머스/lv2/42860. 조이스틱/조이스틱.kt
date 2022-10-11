/*
조이스틱 문제는 재귀로 풀다가풀다가 찾아서 풀었습니다. (출처 : https://nosorae.tistory.com/entry/3%EC%9B%94-4%EC%9D%BC)
풀면서 생각한 건 발상의 전환이 필요하구나 였습니다.
좌우(커서)상하(알파벳맞추기)이동을 함께 하면서 풀려고 했는데
최소상하이동(알파벳맞추기)을 먼저 answer에 더해놓고
최소좌우이동(커서)을 구하면 쉬운 문제였습니다.... ㅜ_ㅜ
 */
class Solution {
    private var min = Int.MAX_VALUE
    private var gName = ""
    fun solution(name: String): Int {
        gName = name
        var answer = 0

        // 전처리
        val check = Array(name.length) { false }
        // 최소 상하 이동(목표 알파벳 만들기) 횟수 먼저 처리 
        for (i in name.indices) {
            if (name[i] == 'A') check[i] = true
            if (name[i] > 'M') answer += ('Z' - name[i] + 1) else answer += (name[i] - 'A')
        }

        // 브루트포스
        bruteforce(0, 0, check)

        // 최소 이동값 더해주기
        answer += min

        return answer
    }
    private fun bruteforce(cur: Int, count: Int, check: Array<Boolean>) {
        // min 보다 같거나 높다면 더이상 검사할 필요도 없다.
        if (count >= min) return

        // 왼오왼오왼 같은 경우에 방문했음에도 방문하지 않은 것처럼 되는 것을 방지하기 위해 매번 새롭게 생성해준다.
        val nextCheck = check.copyOf()
        // 현재 cur는 정답으로 바뀐 것
        nextCheck[cur] = true
        
        var all = true
        for (i in nextCheck.indices) {
            // 하나라도 아직 정답이 아니면 false
            if (!nextCheck[i]) all = false
        }
        // 모든 자리가 정답이라면 갱신 시도
        if (all && min > count) min = count

        // 양방향 각각 재귀로 시도
        // 오른쪽
        if (cur >= gName.length - 1) bruteforce(0, count + 1, nextCheck) else bruteforce(cur + 1, count + 1,nextCheck)
        // 왼쪽
        if (cur <= 0) bruteforce(gName.length - 1, count + 1, nextCheck) else bruteforce(cur - 1, count + 1, nextCheck)
    }
}