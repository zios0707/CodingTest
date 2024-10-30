import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        // 신고 받은 사람 : 신고 한 사람

        for (String s: report) {
            String[] ids = s.split(" ");
            String reporter = ids[0], reported = ids[1];

            Set<String> set = map.getOrDefault(reported, new HashSet<>());
            set.add(reporter);
            map.put(reported, set);
        }

        int[] result = new int[id_list.length];
        for (String id: id_list) {
            if(map.containsKey(id)) {
                Set<String> set = map.get(id);
                if (set.size() >= k) set.forEach(s -> result[getIdx(id_list, s)]++);
            }
        }

        return result;
    }
    
    private int getIdx(String[] list, String target) {
        for (int i = 0; i < list.length; i++) if (list[i].equals(target)) return i;
        return -1;
    }
}