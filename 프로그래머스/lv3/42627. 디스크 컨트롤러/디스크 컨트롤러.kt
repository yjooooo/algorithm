import java.util.PriorityQueue

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0
        
        // 작업이 요청되는 시점 기준 우선순위 큐 (대기큐)
        val wq = PriorityQueue<Job>(compareBy { job -> job.start })

        for (job in jobs) {
            wq.offer(Job(job[0], job[1]))
        }
        println(wq)

        while (wq.isNotEmpty()) {
            // 작업 소요시간 기준 우선순위 큐 (준비큐)
            val rq = PriorityQueue<Job>(compareBy { job -> job.required })
            
            // 요청된 순서대로 준비큐에 들어가고 준비큐에서는 소요시간 기준으로 정렬됨 
            while (wq.isNotEmpty() && time >= wq.peek().start) {
                rq.offer(wq.poll())
            }

            if (rq.isEmpty()) {
                time++
                continue
            }
            time += rq.peek().required
            answer += time - rq.peek().start
            rq.poll()

            for (i in rq.indices) {
                wq.offer(rq.poll())
            }
        }

        answer /= jobs.size

        return answer
    }
}

data class Job(
    var start: Int = 0,
    var required: Int = 0
)