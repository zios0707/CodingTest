import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        List<Integer> ls = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] answer = new int[ls.size()];
        boolean[] isIndexed = new boolean[ls.size()];

        for (int i = 0; i < ls.size(); i++) {
            int index = -1, temp = Integer.MAX_VALUE;

            for (int j = 0; j < ls.size(); j++) if (!isIndexed[j] && temp > ls.get(j)) {
                temp = ls.get(j);
                index = j;
            }

            answer[index] = i;
            isIndexed[index] = true;
        }


        for (int i = 0; i < ls.size(); i++) {
            System.out.print(answer[i]);
            if (i != ls.size() - 1) System.out.print(" ");
        }
    }
}