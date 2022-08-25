import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[1000000];
        Arrays.fill(answer, -1);
        answer[0] = arr[0];
        int current = 1;
        for (int i = 1; i < arr.length; i++) {
            if (answer[current - 1] != arr[i]) {
                answer[current++] = arr[i];
            }
        }
        return Arrays.copyOfRange(answer, 0, current);
    }
}
