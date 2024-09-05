import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, bridgeWeigth = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Pair> inQueue = new LinkedList<>();
        for (int i : truck_weights) queue.add(i);

        do {
            time++;
            while (!inQueue.isEmpty() && inQueue.peek().second + bridge_length <= time) bridgeWeigth -= inQueue.poll().first;

            if (!queue.isEmpty() && bridgeWeigth + queue.peek() <= weight) {
                bridgeWeigth += queue.peek();
                inQueue.add(new Pair(queue.poll(), time));
            }
            
        } while (!inQueue.isEmpty() || !queue.isEmpty());

        return time;
    }

    class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
