import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<String> list = new ArrayList<>();
        for (String s1: intStrs) if(Integer.valueOf(s1.substring(s, s + l)) > k) list.add(s1.substring(s, s + l));


        int[] ints = new int[list.size()]; int Iter = 0;
        for (String s1: list) ints[Iter++] = Integer.valueOf(s1);
        
        return ints;
    }
}