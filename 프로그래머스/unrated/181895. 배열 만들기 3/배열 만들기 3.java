import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> array = new ArrayList<>();

        for(int[] i: intervals) for(int j = i[0]; j <= i[1]; j++) array.add(arr[j]);

        int[] result = new int[array.size()];
        for(int i = 0; i < array.size(); i++) result[i] = array.get(i);

        return result;
    }
}