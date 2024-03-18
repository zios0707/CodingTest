import java.util.*;

public class Main {

    static int[] memo = new int[5001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 5001; i++) memo[i] = 5001;
        memo[3] = memo[5] = 1;
        int result = exe(n);
        if(result >= 5001) result = -1;
        System.out.println(result);
    }

    private static int exe(int val) {
        if(val <= 2 || val == 4) return memo[val];
        if(memo[val] == 5001) memo[val] = Math.min(exe(val - 3), exe(val - 5)) + 1;
        return memo[val];
    }
}