import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Map<Triple, Integer> memo = new HashMap<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = sc.nextInt(), b = 0, c = 0;

        if (n >= 2) b = sc.nextInt();
        if (n == 3) c = sc.nextInt();


        bfs(a, b, c);

        System.out.println(memo.get(
                new Triple(a, b, c)
        ));
    }

    static int[] d1 = new int[]{9, 9, 3, 3, 1, 1};
    static int[] d2 = new int[]{3, 1, 9, 1, 9, 3};
    static int[] d3 = new int[]{1, 3, 1, 9, 3, 9};
    private static Integer bfs(int a, int b, int c) {
        a = checkNegative(a); b = checkNegative(b); c = checkNegative(c);

        if (a == 0 && b == 0 && c == 0) return 0;

        Triple trp = new Triple(a, b, c);

        if (memo.containsKey(trp)) return memo.get(trp);

        for (int i = 0; i < 6; i++) {
            int cnt = bfs(a - d1[i], b - d2[i], c - d3[i]) + 1;

            if (!memo.containsKey(trp) || memo.get(trp) > cnt) memo.put(trp, cnt);
        }

        return memo.get(trp);
    }

    private static int checkNegative(int n) {
        return Math.max(n, 0);
    }

    private static class Triple{
        Integer a, b, c;

        Triple(Integer a, Integer b, Integer c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triple triple = (Triple) o;
            return Objects.equals(a, triple.a) && Objects.equals(b, triple.b) && Objects.equals(c, triple.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}
