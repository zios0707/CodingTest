import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i : score) {
            queue.add(i);
            queue.sort(Integer::compareTo);
            if (queue.size() > k) queue.removeFirst();
            list.add(queue.getFirst()); 
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
    //what
}