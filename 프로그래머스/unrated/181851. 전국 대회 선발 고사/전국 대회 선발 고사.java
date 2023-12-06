class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int result = 0;
        int count = 0;
        for (int i = 1; i <= rank.length; i++) { // i 등 수
            for (int j = 0; j < rank.length; j++) { // j 위치
                if(attendance[j] && rank[j] == i && count < 3) {
                    result = result * 100 + j;
                    count++;
                }
            }
            if(count == 3) break;
        }
        return result;
    }
}