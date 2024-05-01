import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>(); /* keyword->-closest index*/
        ArrayList<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = 0;
            if(map.containsKey(chars[i])) index = i - map.get(chars[i]);
            else index = -1;
            result.add(index);
            map.put(chars[i], i);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}