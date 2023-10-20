class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        
        int s1 = Integer.valueOf(str1 + str2);
        int s2 = Integer.valueOf(str2 + str1);
        if (s1 > s2) answer = s1;
        else answer = s2;
        
            
            
        return answer;
    }
}