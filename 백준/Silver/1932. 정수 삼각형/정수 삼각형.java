import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][n];
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        memo[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) for (int j = 0; j <= i; j++)
            memo[i][j] = arr[i][j] + Math.max(memo[i + 1][j], memo[i + 1][j + 1]);

        System.out.println(memo[0][0]);
    }
}