import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int cnt = 0;
    long q1s = 0, q2s = 0;
    Queue<Long> q1 = new LinkedList<>();
    Queue<Long> q2 = new LinkedList<>();

    public int solution(int[] queue1, int[] queue2) {
        for (long i : queue1) { q1.add(i); q1s += i; }
        for (long i : queue2) { q2.add(i); q2s += i; }

        while (q1s != q2s) {
            if (q1s > q2s) addQueue1();

            if (q1s < q2s) addQueue2();

            if (cnt > queue1.length * 3) {
                cnt = -1; break;
            }
        }

        return cnt;
    }

    private void addQueue1() {
        while(!q1.isEmpty() && q1s > q2s) {
            long temp = q1.poll();
            q1s -= temp; q2s += temp;
            q2.add(temp);
            cnt++;
        }
    }

    private void addQueue2() {
        while(!q2.isEmpty() && q1s < q2s) {
            long temp = q2.poll();
            q2s -= temp; q1s += temp;
            q1.add(temp);
            cnt++;
        }
        
    }
}