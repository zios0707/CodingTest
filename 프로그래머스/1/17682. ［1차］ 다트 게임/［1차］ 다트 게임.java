class Solution {
    public int solution(String dartResult) {
        String rgx = "\\d+[A-Z][*#]?";
        String[] results = new String[]{dartResult.substring(0, dartResult.length() - dartResult.split(rgx, 2)[1].length()),
                                        dartResult.substring(dartResult.length() - dartResult.split(rgx, 2)[1].length(), dartResult.length() - dartResult.split(rgx, 3)[2].length()),
                                        dartResult.substring(dartResult.length() - dartResult.split(rgx, 3)[2].length())};
        int flex[] = new int[]{1, 1, 1};
        int score = 0;
        for (int i = 2; i >= 0; i--) {
            int point = 0;
            for (char c: results[i].toCharArray()) {
                if('0' <= c && c <= '9') point = point * 10 + c - '0';
                if (c == 'D') point *= point;
                if (c == 'T') point *= point * point;
                if (c == '*') {
                    flex[i] *= 2;
                    if(i != 0) flex[i - 1] *= 2;
                }
                if (c == '#') flex[i] *= -1;
            }
            score += flex[i] * point;
        }

        return score;
    }
}