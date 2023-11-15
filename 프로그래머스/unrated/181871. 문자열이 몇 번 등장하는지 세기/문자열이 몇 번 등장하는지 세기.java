class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) if(pat.equals(myString.substring(i, i + pat.length()))) cnt++;
        return cnt;
    }
}