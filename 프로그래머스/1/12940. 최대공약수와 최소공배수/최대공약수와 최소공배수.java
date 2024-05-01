import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, int m) {
        int minM = 3, maxD = 12;
        ArrayList<Integer> left = new ArrayList<Integer>(); // 최소 공배수, 최대 공약수를 구하는데 들어갈 값
        int[] down = cal(n, m, left); // 최대 공약수를 구하는데 들어갈 값
        
        int leftVal = left.stream().mapToInt(i -> i).reduce(1, (a, b) -> a * b);
        int downVal = down[0] * down[1];
        
        return new int[]{leftVal, leftVal * downVal};
    }
    
    private int[] cal(int n, int m, ArrayList<Integer> left) {
        int min = Math.min(Math.min(n, m), Math.max(n, m) / 2);
        for(int i = 1; i <= min; i++) if(n % i == 0 && m % i == 0) {
            n /= i; m /= i;
            left.add(i);
            i = 1;
        }
        return new int[]{n, m};
    }
}