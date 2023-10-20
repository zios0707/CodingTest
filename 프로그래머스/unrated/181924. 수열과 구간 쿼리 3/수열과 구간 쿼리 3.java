class Solution {
    public int[] solution(int[] arr, int[][] queries) { 
        for (int[] row: queries) {
        int tmp = arr[row[0]];
        arr[row[0]] = arr[row[1]];
        arr[row[1]] = tmp;
        }
        return arr;
    }
}