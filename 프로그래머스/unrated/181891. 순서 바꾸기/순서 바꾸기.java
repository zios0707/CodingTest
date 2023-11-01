import java.util.ArrayList; 

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : num_list) list.add(i);

        result.addAll(list.subList(n, list.size()));
        result.addAll(list.subList(0, n));

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}