import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>(); // key - index
        HashMap<String, Integer> playCount = new HashMap<>(); // key - sum(plays)

        for (int i = 0; i < genres.length; i++) {
            List<Integer> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            map.put(genres[i], list);
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (int i = 0; i < map.size(); i++) {
            String key = max(playCount);
            playCount.remove(key);

            for (int j : topTwo(map.get(key), plays)) result.add(j);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private String max(HashMap<String, Integer> map) {
        String index = map.keySet().toArray(String[]::new)[0];

        for (String s : map.keySet()) index = (map.get(s) > map.get(index)) ? s : index;

        return index;
    }

    private int[] topTwo(List<Integer> list, int[] plays) {
        List<Integer> save = new ArrayList<>();

        int len = list.size();
        for (int i = 0; i < len; i++) {
            int index = list.get(0);
            for (int j : list) {
                index = (plays[j] > plays[index]) ? j : index;
            }
            list.remove(Integer.valueOf(index));
            save.add(index);
        }

        return save.stream().limit(2).mapToInt(i -> i).toArray();
    }
}