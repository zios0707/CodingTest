import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    List<Integer> frontSearch = new ArrayList<>();
    List<Integer> backSearch = new ArrayList<>();

    List<List<Integer>> nodeMap;
    List<Integer> ymap;
    public int[][] solution(int[][] nodeinfo) {
        Set<Integer> ys = new HashSet<>();
        // X(indexed), Y, n
        nodeMap = new ArrayList<>();
        // X 최대값, Y 최대값
        int x = 0, y = 0;
        for (int i = 0; i < nodeinfo.length; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(nodeinfo[i][0]);
            arr.add(nodeinfo[i][1]);
            x = Math.max(x, nodeinfo[i][0]);
            y = Math.max(y, nodeinfo[i][1]);
            ys.add(nodeinfo[i][1]);
            arr.add(i + 1);
            nodeMap.add(arr);
        }

        nodeMap = nodeMap.stream().sorted((o1, o2) -> o1.get(0) - o2.get(0)).collect(Collectors.toUnmodifiableList());
        ymap = ys.stream().sorted().collect(Collectors.toUnmodifiableList());


        // 루트 노드의 좌표값
        search(0, nodeMap.size() - 1);

        return new int[][]{frontSearch.stream().mapToInt(i -> i).toArray(), backSearch.stream().mapToInt(i -> i).toArray()};
    }

    private void search(int front, int back) {
        if (front > back) return;
        int root = getRootX(front, back);

        frontSearch.add(getNodeValue(root));
        search(front, root - 1);
        search(root + 1, back);
        backSearch.add(getNodeValue(root));
    }

    private Integer getRootX(int front, int back) {
        return nodeMap.indexOf(nodeMap.subList(front, back + 1).stream().min((o1, o2) -> o2.get(1) - o1.get(1)).get());
    }

    private Integer getNodeValue(int x) {
        return nodeMap.get(x).get(2);
    }
}