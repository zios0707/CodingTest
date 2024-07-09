import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<Pair> pq = new LinkedList<>();
    
    int[][] map;

    int[] d;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        map = new int[n + 1][n + 1];
        d = new int[n + 1];

        for (int[] ints : map) Arrays.fill(ints, Integer.MAX_VALUE); // 배열 초기화

        for (int[] fare : fares) insertPrime(fare[0], fare[1], fare[2]);// map[n][m] n 에서 m 까지 가는데 드는 비용.

        for (int i = 1; i <= n; i++) map[i][i] = 0;

        int[] list = new int[]{s, a, b};
        
        for (int i : list) {
            Arrays.fill(d, Integer.MAX_VALUE);
            dijkstra(i);
        } // 라인별 최적 해 구하기

        int result = Integer.MAX_VALUE;

        int AtoB = map[a][b];
        for (int i = 1; i <= n; i++) {
            int ItoA = map[i][a];
            int ItoB = map[i][b];
            int ItoAorB = Math.min(ItoA, ItoB);

            d[i] = Math.min(Math.abs(ItoA + ItoB), Math.abs(ItoAorB + AtoB));

            result = Math.min(result, Math.abs(d[i] + map[s][i]));
        }


        return result;
    }

    private void dijkstra(int start) {
        d[start] = 0;

        pq.offer(new Pair(start, 0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int idx = curr.first;

            int dist = curr.second;

            if(dist > d[idx]) continue;

            for (int i = 1; i < map.length; i++) {
                if (map[idx][i] == Integer.MAX_VALUE || map[idx][i] == 0) continue;

                Pair nextPair = new Pair(i, dist + map[idx][i]);
                
                if (nextPair.second < d[i]) {
                    insertPrime(start, i, nextPair.second);
                    pq.offer(nextPair);
                }
            }
        }
    }

    private void insertPrime(int a, int b, int value) {
        int primeValue = Math.min(value, map[a][b]);

        d[b] = primeValue;

        map[a][b] = primeValue;
        map[b][a] = primeValue;
    }
}

class Pair {
    Integer first; // Y
    Integer second; // VALUE

    Pair(Integer a, Integer b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return this.first + " - " + this.second;
    }
}