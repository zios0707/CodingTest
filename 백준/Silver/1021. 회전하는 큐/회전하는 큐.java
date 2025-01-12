import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i + 1);

        while (m >= 1) {
            int target = sc.nextInt();

            while(q.peek() != target) {
                cnt++;
                int idx = q.stream().collect(Collectors.toUnmodifiableList()).indexOf(target);
                if (idx <= q.size() / 2) {
                    q.add(q.poll());
                }else {
                    q.addFirst(q.pollLast());
                }
            }

            q.poll();
            m--;
        }

        System.out.println(cnt);
    }
}