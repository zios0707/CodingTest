import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

class Solution {
    Map<Integer, List<String>> map = new HashMap<>();
    boolean[] ways;
    int cnt = 0;
    public int solution(String[][] clothes) {
        List<String> indexes = new ArrayList<>();

        for (String[] cloth: clothes) {
            if (!indexes.contains(cloth[1])) indexes.add(cloth[1]);
            List<String> list = map.getOrDefault(indexes.indexOf(cloth[1]), new ArrayList<>());
            list.add(cloth[0]);
            map.put(indexes.indexOf(cloth[1]), list);
        }

        ways = new boolean[map.size()];
        Arrays.fill(ways, true);

        dfs(0, 1);

        return cnt;
    }

    private void dfs(int left, int temp) {
        if (left == ways.length) return;

        for (; left < ways.length; left++) if (ways[left]) {
            int value = temp * map.get(left).size();
            cnt += value;

            ways[left] = false;
            dfs(left + 1, value);
            ways[left] = true;
        }
    }
}