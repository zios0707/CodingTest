import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0], b = slicer[1], c = slicer[2];
        List<Integer> list = new ArrayList<>();
        
        if(n == 1) for(int i = 0; i <= b; i++) list.add(num_list[i]);
        else if(n == 2) for(int i = a; i < num_list.length; i++) list.add(num_list[i]);
        else if(n == 3) for(int i = a; i <= b; i++) list.add(num_list[i]);
        else for(int i = a; i <= b; i += c) list.add(num_list[i]);

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}