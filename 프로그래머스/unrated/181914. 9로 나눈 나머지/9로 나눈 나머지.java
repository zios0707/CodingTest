class Solution {
    public int solution(String number) { 
        int val = 0;

        for (char c: number.toCharArray()
             ) {
            val += Integer.valueOf(c - '0');
        }

        return val % 9;
    }
}