import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < players.length; i++) {
            int thisPlayer = players[i];
            int needs = thisPlayer / m;

            while (!q.isEmpty() && q.peek() + k <= i) q.poll();

            while (needs > q.size()) {
                q.add(i);
                result++;
            }
        }
        
        return result;
    }
}