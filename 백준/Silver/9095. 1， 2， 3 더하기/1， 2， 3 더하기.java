import java.util.*;

public class Main {

    static int[] memo = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo[0] = 1; memo[1] = 2; memo[2] = 4;
        for (int i = 0; i < n; i++) System.out.println(exe(sc.nextInt() - 1));
    }

    private static int exe(int val) {
        if(memo[val] == 0) {
            memo[val] = exe(val - 1) + exe(val - 2) + exe(val - 3);
        }
        return memo[val];
    }
}
