import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stage = new int[N + 1];

        for (int i: stages) {
            if (i <= N) stage[i]++;
        };

        Map<Double, PriorityQueue<Integer>> map = new HashMap<>();

        int beforeCleared = 0;
        for (int i = 1; i <= N; i++) {
            double val = (stages.length - beforeCleared == 0) ? 0 : stage[i] / (double) (stages.length - beforeCleared);

            PriorityQueue<Integer> pq = map.getOrDefault(val, new PriorityQueue<>());
            pq.add(i);
            map.putIfAbsent(val, pq);

            beforeCleared += stage[i];
        }

        int iter = 0;
        int[] result = new int[N];

        for (double key : map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toUnmodifiableList())) {
            PriorityQueue<Integer> pq = map.get(key);
            while (!pq.isEmpty()) result[iter++] = pq.poll();
        }

        return result;
    }
}