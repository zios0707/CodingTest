import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(myString.split("x")).forEach(s -> list.add(s.length()));
        if(myString.endsWith("x")) list.add(0);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}