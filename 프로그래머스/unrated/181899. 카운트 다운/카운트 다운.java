import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int start, int end_num) {
        List<Integer> list = new ArrayList<>();
        for(int i = start; i >= end_num; i--)
            list.add(i);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);


        return result;
    }
}