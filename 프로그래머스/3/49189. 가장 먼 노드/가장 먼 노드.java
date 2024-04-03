import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private HashMap<Integer, Integer> dist = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<>();
    private Integer max = 0;
    public int solution(int n, int[][] edge) {
        graph.add(new ArrayList<>());
        for (int i = 1; i <= n; i += 1) {
            graph.add(new ArrayList<>());
            dist.put(i, Integer.MAX_VALUE);
        }
        for (int[] i : edge) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        dist.put(1, 0);

        queue.add(1);
        bfs();
        
        return (int) dist.values().stream().flatMapToInt(IntStream::of).filter(i -> i == max).count(); // <<-- forEach문 써서 if 문으로 count 변수를 활용했는데 놀랍게도 안됐음. 근데 stream 쓰니까 잘굴러감.
    }

    private void bfs() {
        while(!queue.isEmpty()) {
            Integer index = queue.poll();
            List<Integer> ways = graph.get(index);
            int nowDist = dist.get(index) + 1;
            for (Integer i : ways) {
                if(dist.get(i) > nowDist) {
                    dist.put(i, nowDist);
                    queue.add(i);
                }
            }

            max = Math.max(nowDist - 1, max);
        }
    }
}