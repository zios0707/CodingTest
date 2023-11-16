import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        LinkedList<String> list = new LinkedList<>();
        Arrays.stream(arr).mapToObj(String::valueOf).forEach(n -> {
            if(list.isEmpty()) list.add(n);
            else if(list.getLast().equals(n)) list.removeLast();
            else list.add(n);
        });
        return (list.isEmpty()) ? new int[]{-1} : list.stream().mapToInt(Integer::parseInt).toArray();
    }
}