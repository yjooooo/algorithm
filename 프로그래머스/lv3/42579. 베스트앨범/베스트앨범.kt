import java.util.LinkedList
import kotlin.collections.HashMap

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        val genreCount = HashMap<String, IntArray>()
        val genreWithPlay = HashMap<String, IntArray>()

        // 속한 노래가 많이 재생된 장르 먼저
        for ((idx, p) in plays.withIndex()) {
            val genreName = genres[idx]
            if (genreCount[genreName] == null) {
                genreCount[genreName] = intArrayOf(p)
                genreWithPlay[genreName] = intArrayOf(idx)
            } else {
                genreCount[genreName] = requireNotNull(genreCount[genreName]) + p
                genreWithPlay[genreName] = requireNotNull(genreWithPlay[genreName]) + idx
            }
        }
        val sortedGenres = LinkedList(genreCount.entries).apply { sortByDescending { it.value.sum() } }

        // 장르 내에서 많이 재생된 노래 먼저
        // 장르 내에서 재생 횟수가 같은 노래 중 고유 번호가 낮은 노래 먼저
        for (g in sortedGenres) {
            val playsWithIdx = HashMap<Int, Int>().also {
                for ((idx, p) in requireNotNull(genreWithPlay[g.key]).withIndex()) {
                    it[p] = g.value[idx]
                }
            }
            val sortedPlays = LinkedList(playsWithIdx.entries).apply { sortByDescending { it.value } }
            for ((idx, p) in sortedPlays.withIndex()) {
                answer += p.key
                // 장르 별로 가장 많이 재생된 노래를 최대 두 개까지
                if (idx == 1) break
            }
        }

        return answer
    }
}