import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> newScoville = new PriorityQueue();
        
        for (int n : scoville) {
            newScoville.add(n);
        }
        
        while (newScoville.peek() <= K) {
            if (newScoville.size() == 1) {
                return -1;
            }
            answer++;
            int n = newScoville.poll() + newScoville.poll() * 2;
            
            newScoville.add(n);
        }
        
        return answer;
    }
}