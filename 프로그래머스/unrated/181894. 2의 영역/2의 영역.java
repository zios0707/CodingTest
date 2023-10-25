import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i: arr) array.add(i);

        if(!array.contains(2)) return new int[]{-1};
        for(int i = array.indexOf(2); i <= array.lastIndexOf(2); i++) result.add(array.get(i));

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}