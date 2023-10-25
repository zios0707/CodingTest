import java.util.List; 
import java.util.ArrayList; 
class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        boolean cnt = true;
        for (int i: arr) list.add(i);
        for (int i:query) {
            if (cnt) list = list.subList(0, i + 1);
            else list = list.subList(i, list.size());

            cnt = !cnt;
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}