import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int cnt = 0;

            List<Pair> ls = new ArrayList<>();
            Set<Pair> deleted = new HashSet<>();

            for (int j = 0; j < m; j++) {
                String[] temp = br.readLine().split(" ");
                ls.add(new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }

            ls = ls.stream().sorted((i1, i2) -> i1.a - i2.a).collect(Collectors.toList());
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (min > ls.get(j).b) min = ls.get(j).b;
                if (min < ls.get(j).b) deleted.add(ls.get(j));
            }

            ls = ls.stream().sorted((i1, i2) -> i1.b - i2.b).collect(Collectors.toList());
            min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (min > ls.get(j).a) min = ls.get(j).a;
                if (min < ls.get(j).a) deleted.add(ls.get(j));
            }

            System.out.println(ls.size() - deleted.size());
        }
    }

    private static class Pair{
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }
    }
}