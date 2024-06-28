import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: scoville) pq.offer(i);
        
        while(pq.peek() < K) {
            if(pq.size() < 2) return -1;
            int first = pq.poll(), second = pq.poll();
            pq.offer(first + second * 2);
        }
        
        return scoville.length - pq.size();
    }
}