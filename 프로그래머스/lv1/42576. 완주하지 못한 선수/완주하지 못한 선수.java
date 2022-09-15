import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> incompletion = new HashMap<String, Integer>();
        
        for (String p : participant) {
            incompletion.put(p, incompletion.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            incompletion.put(c, incompletion.get(c) - 1);
        }
            
        for (String p : participant) {
            if (incompletion.get(p) == 1) {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}