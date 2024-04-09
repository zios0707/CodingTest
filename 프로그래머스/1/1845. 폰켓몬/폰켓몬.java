import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int count = (int) Arrays.stream(nums).distinct().count();
        return (count > nums.length / 2) ? nums.length / 2 : count;
    }
}