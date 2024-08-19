import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<Integer, List<Integer>> tree;
    List<Integer> INFO;
    boolean[] canVisit;
    int max, sheep, wolves;

    public int solution(int[] info, int[][] edges) {
        max = 1; sheep = 1; wolves = 0;
        tree = new HashMap<>();
        canVisit = new boolean[info.length];

        Set<Integer> startNodes = Arrays.stream(edges).map((val) -> val[0]).collect(Collectors.toUnmodifiableSet());

        for (int[] i : edges) {
            List<Integer> ways = tree.getOrDefault(i[0], new ArrayList<>());
            if(info[i[1]] == 0 || startNodes.contains(i[1])) {
                ways.add(i[1]);
            }
            tree.put(i[0], ways);
        }

        INFO = Arrays.stream(info).boxed().collect(Collectors.toUnmodifiableList());

        dfs(0);

        return max;
    }

    private void dfs(int index) {
        boolean hasChild = tree.containsKey(index);

        if (hasChild) for (Integer i : tree.get(index)) canVisit[i] = true;

        for (int i = 0; i < canVisit.length; i++) {
            boolean isSheep = INFO.get(i) == 0;
            if (canVisit[i] && wolves < sheep + ((isSheep) ? 1 : -1)) {
                if (isSheep) upSheep();
                else upWolves();
                canVisit[i] = false;
                dfs(i);
                canVisit[i] = true;
                if (isSheep) downSheep();
                else downWolves();
            }
        }

        if (hasChild) for (Integer i : tree.get(index)) canVisit[i] = false;
        canVisit[index] = true;
    }

    private void upSheep() {
        if (max < ++sheep) max = sheep;
    }

    private void downSheep() {
        --sheep;
    }

    private void upWolves() {
        ++wolves;
    }

    private void downWolves() {
        --wolves;
    }
}