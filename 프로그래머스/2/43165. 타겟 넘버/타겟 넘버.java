import java.util.*;

class Solution {
    int answer = 0;
    int TARGET;
    int[] NUMBERS;
    boolean[] visited;
    Set<boolean[]> set;

    public int solution(int[] numbers, int target) {
        set = new HashSet<>();
        TARGET = target;
        NUMBERS = numbers;
        visited = new boolean[numbers.length];

        dfs(0, Arrays.stream(numbers).sum());

        return answer;
    }

    private void dfs(int left, int value) {
        if (value == TARGET && add(visited.clone())) {
            answer++;
        }

        for (int i = left; i < NUMBERS.length; i++) if (!visited[i]) {
            visited[i] = true;
            int next = value - NUMBERS[i] * 2;
            if (next >= TARGET) dfs(i + 1, next);
            visited[i] = false;
        }
    }

    private boolean add(boolean[] clone) {
        if (set.stream().noneMatch(b -> Arrays.equals(b, clone))) return set.add(clone);
        return false;
    }
}