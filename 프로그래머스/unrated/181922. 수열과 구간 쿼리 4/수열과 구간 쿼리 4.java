class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] in: queries
             ) {
            int first = in[0], last = in[1], much = in[2];
            for(int i = first; i <= last; i++) {
                if(i % much == 0) {
                    arr[i]++;
                } 
            } 
        } 
        return arr;
    }
}