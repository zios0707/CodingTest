import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int a = Arrays.stream(num_list).sum();
        int b = 1;
        for(int i: num_list) b *= i;
        System.out.println(Math.pow(a, 2) + ", " + b);
        if(Math.pow(a, 2) > b) return 1;
        return 0;
    }
}