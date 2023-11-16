class Solution {
    public int solution(String binomial) {
        String[] result = binomial.split(" ");
        if(result[1].equals("+")) return Integer.parseInt(result[0]) + Integer.parseInt(result[2]);
        if(result[1].equals("-")) return Integer.parseInt(result[0]) - Integer.parseInt(result[2]);
        return Integer.parseInt(result[0]) * Integer.parseInt(result[2]);
    }
}