class Solution {
    public int solution(int[] arr, int idx) {
        for(int i = idx; ; i++) {
            if(i == arr.length) return -1;
            if(arr[i] == 1) return i;
        }
    }
}