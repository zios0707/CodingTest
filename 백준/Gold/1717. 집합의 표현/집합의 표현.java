import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static int[] group;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = readLine();

        int range = temp[0];
        int count = temp[1];

        group = new int[range + 1];

        for (int i = 0; i <= range; i++) group[i] = i;

        for (int i = 0; i < count; i++) {
            temp = readLine();

            int commend = temp[0];

            int a = temp[1];
            int b = temp[2];

            if (commend == 0) { // merge set
                union(a, b);
            }else { // print is included
                System.out.println((find(a) == find(b)) ? "YES" : "NO");
            }
        }
    }

    private static int find(int u) {
        if (u == group[u]) return u;

        return group[u] = find(group[u]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        group[u] = v;
    }

    private static int[] readLine() throws Exception {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}