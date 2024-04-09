import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : completion) map.put(s, map.getOrDefault(s, 0) - 1);
        for (String s : map.keySet()) if (map.get(s) == 1) return s;
        return null; // 컴파일러 오작동해서 이렇게함
    }
}