import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isEnd = false;
    static boolean[] visited = new boolean[9];
    static List<Integer> list = new ArrayList<>();
    static int sum = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) list.add(sc.nextInt());

        sum = list.stream().reduce(0, Integer::sum);

        search(0);

        list.sort(Integer::compareTo);
        list.forEach(System.out::println);
    }

    private static void search(int depth) {
        if (isEnd) return;

        if (depth == 2) {
            int temp = sum;

            for (int i = 0; i < visited.length; i++) if (visited[i]) temp -= list.get(i);

            if (temp == 100) {
                isEnd = true;
                List<Integer> newlist = new ArrayList<>();

                for (int i = 0; i < visited.length; i++) if (!visited[i]) newlist.add(list.get(i));

                list = newlist;
            }
        }

        for (int i = 0; i < visited.length; i++) if (!visited[i]) {
            visited[i] = true;
            search(depth + 1);
            visited[i] = false;
        }
    }
}
