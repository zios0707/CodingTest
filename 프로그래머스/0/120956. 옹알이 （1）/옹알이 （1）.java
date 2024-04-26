class Solution {
    public int solution(String[] babbling) {
        String[] goodbabble = new String[]{"aya", "ye", "woo", "ma"};
        int count = 0;
        for (String s : babbling) {
            while (!s.isBlank()) {
                int len = s.length();
                for (int i = 0; i < 4; i++) if (s.startsWith(goodbabble[i])) {s = s.substring(goodbabble[i].length());}
                if (len == s.length()) {count--; break;}
            }
            count++;
        } 
        return count;
    }
}