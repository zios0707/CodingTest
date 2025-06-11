import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();

        List<Integer> ls = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toUnmodifiableList()));
        ls.add(0);
        ls = ls.stream().sorted().collect(Collectors.toUnmodifiableList());

        int leftIdx = -1, rightIdx = -1;

        int target = sc.nextInt();

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) < target) {
                leftIdx = i;
            }else if(ls.get(i) > target && rightIdx == -1) {
                rightIdx = i;
            }
        }

        if (rightIdx == -1 || leftIdx == -1 || ls.stream().anyMatch(i -> i == target)) {
            System.out.println(0);
            return;
        }

        System.out.println((target - ls.get(leftIdx) - 1) * (ls.get(rightIdx) - target) + (ls.get(rightIdx) - target - 1));
    }
}
