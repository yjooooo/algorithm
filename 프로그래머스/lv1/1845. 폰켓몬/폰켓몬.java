import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = nums.length / 2;
        int typeCount = numsSet.size();
        return typeCount < maxCount ? typeCount : maxCount;
    }
}