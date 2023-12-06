class Solution {
    public int solution(double flo) {
        return Integer.parseInt(String.valueOf(flo).split("\\.")[0]);
    }
}