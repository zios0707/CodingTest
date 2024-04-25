class Solution {
    public int solution(int n) {
        int result = 0;
        for(int i = 0; i < n; i++) {
            result++;
            while(result % 3 == 0 || Integer.toString(result).contains("3")) result++;
        }
        return result;
    }
}