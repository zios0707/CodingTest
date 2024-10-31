import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    int END_TIME = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (String s: records) {
            String[] ss = s.split(" ");
            int carNum = Integer.parseInt(ss[1]);
            Queue<Integer> list = map.getOrDefault(carNum, new PriorityQueue<>());
            String[] splitVal = ss[0].split(":");
            list.add(Integer.parseInt(splitVal[0]) * 60 + Integer.parseInt(splitVal[1]));
            map.put(carNum, list);
        }

        List<Integer> carSet = map.keySet().stream().sorted().collect(Collectors.toUnmodifiableList());

        int[] result = new int[carSet.size()];
        for (int i: map.keySet()) {
            int carIdx = carSet.indexOf(i);
            Queue<Integer> q = map.get(i);

            boolean isOn = false;
            int temp = 0;
            while (!q.isEmpty()) {
                isOn = !isOn;

                if (isOn) temp = q.poll();
                else result[carIdx] += q.poll() - temp;
            }
            if (isOn) result[carIdx] += END_TIME - temp;
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = ((result[i] >= fees[0]) ? (result[i] - fees[0] + fees[2] - 1) / fees[2] * fees[3] : 0) + fees[1];
        }

        return result;
    }
}