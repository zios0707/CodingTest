class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray(); 
        
        for(int i = 0; i < str1.length(); i++) {
            answer += String.valueOf(chars1[i]) + String.valueOf(chars2[i]);
        }
        
        
        return answer;
    }
}