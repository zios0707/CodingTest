class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++) {
            Boolean cnt = Boolean.TRUE;
            for (int j : indices) if (i == j) cnt = Boolean.FALSE;
            if(cnt) answer += my_string.charAt(i);
        }

        return answer;
    }
}