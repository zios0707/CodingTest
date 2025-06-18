import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int[] group;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        List<Integer> ls = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toUnmodifiableList()));

        int left = 0;
        int right = ls.size() - 1;
        int defaultSum = Math.abs(ls.get(right) + ls.get(left));

        Pair best = new Pair();
        best.left = left;
        best.right = right;

        while (left < right) {
            int sum = ls.get(right) + ls.get(left);

            if (defaultSum >= Math.abs(sum)) {
                best.left = left;
                best.right = right;
                defaultSum = Math.abs(sum);

                if (sum == 0) break;
            }

            if (sum < 0) {
                left++;
            }else {
                right--;
            }
        }

        System.out.println(ls.get(best.left) + " " + ls.get(best.right));
    }


    private static class Pair {
        int left;
        int right;
    }
}