import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] temp = new int[triangle.length][triangle.length];
        temp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            // 가장 왼쪽
            temp[i][0] = temp[i-1][0] + triangle[i][0];
            
            // 중간
            for (int j = 1; j <= i; j++) {
                temp[i][j] = triangle[i][j] + Math.max(temp[i - 1][j - 1], temp[i - 1][j]);
            }
            
            // 가장 오른쪽
            temp[i][i] = temp[i-1][i-1] + triangle[i][i];
        }
        
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, temp[triangle.length - 1][i]);
        }
        
        return answer;
    }
}