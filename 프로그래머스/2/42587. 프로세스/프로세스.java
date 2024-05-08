import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;
class Solution {
    public int solution(int[] priorities, int location) {
        priorities[location] += 10;
        LinkedList<Integer> list = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toUnmodifiableList()));

        int[] sizes = new int[10];
        for (int i : priorities) sizes[i % 10]++;

        int count = 1;
        while (true) {
            int max = getHighestIndex(sizes);
            int polled = list.poll();
            if (polled % 10 == max) {
                if(polled > 9) break;
                count++;
                sizes[max]--;
            }else list.add(polled);
        }
        return count;
    }

    public int getHighestIndex(int[] list) {
        int i;
        for (i = 9; i >= 0; i--) {
            if(list[i] != 0) break;
        }
        return i;
    }
}