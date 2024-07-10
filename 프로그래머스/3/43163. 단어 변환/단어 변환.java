import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    List<String> list;

    boolean[][] map;

    int cnt = Integer.MAX_VALUE;
    int endPoint;

    boolean[] isVisited;

    public int solution(String begin, String target, String[] words) {
        list = new ArrayList<>(List.of(words));
        list.add(begin);
        System.out.println(list);

        if (Arrays.stream(words).filter(s -> s.equals(target)).findFirst().isEmpty()) return 0;

        endPoint = Arrays.stream(words).collect(Collectors.toUnmodifiableList()).indexOf(target);

        map = new boolean[list.size()][list.size()];
        isVisited = new boolean[list.size()];
        Arrays.fill(isVisited, false);
        isVisited[list.size() - 1] = true;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                map[i][j] = isMatches(list.get(i), list.get(j)); // 단어가 length - 1 개 일치하는가
            }
        }

        dfs(list.size() - 1, 0);

        return cnt;
    }

    private void dfs(int start, int depth) {

        if (start == endPoint) {
            cnt = Math.min(cnt, depth);
            return;
        }

        map = map;

        for (int i = 0; i < map.length; i++) {
            if (!isVisited[i] && map[start][i]) {
                isVisited[i] = true;
                dfs(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private boolean isMatches(String a, String b) {
        int cnt = 0;

        char[] Achars = a.toCharArray();
        char[] Bchars = b.toCharArray();


        for (int i = 0; i < a.length(); i++) if (Achars[i] == Bchars[i]) cnt++;

        return cnt + 1 == a.length();
    }
}