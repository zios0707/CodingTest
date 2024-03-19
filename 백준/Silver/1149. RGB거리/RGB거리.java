import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        String[] query;
        for (int i = 0; i < n; i++) {
            query = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(query[j]);
        }

        for (int i = 1; i < n; i++)
            for (int j = 0; j < 3; j++)
                map[i][j] += Math.min(map[i - 1][(j + 1) % 3], map[i - 1][(j + 2) % 3]);
        System.out.println(Arrays.stream(map[n - 1]).min().getAsInt());
    }
}