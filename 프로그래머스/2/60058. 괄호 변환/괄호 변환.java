import java.util.*;

class Solution {
    public String solution(String p) {
        return check(p);
    }

    private String check(String s) {
        if (s.isEmpty()) return s;

        int firstIdx = firstRight(s);
        String u = s.substring(0, firstIdx), v = s.substring(firstIdx);

        if (checkIsRight(u)) {
            return u + check(v);
        }else {
            return  "(" + check(v) + ")" + flip(u.substring(1, u.length() - 1));
        }

    }


    private boolean checkIsRight(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            if (c == ')') cnt--;

            if (cnt < 0) return false;
        }

        return true;
    }

    private int firstRight(String s) {
        int cnt = 0, endCnt = 0;

        for (char c : s.toCharArray()) {
            endCnt++;
            if (c == '(') cnt++;
            if (c == ')') cnt--;

            if (cnt == 0) return endCnt;
        }

        return -1;
    }

    private String flip(String s) {
        Optional<String> oString = s.chars().mapToObj(c -> String.valueOf((c == '(') ? ')' : '(')).reduce(((s1, s2) -> s1 + s2));
        return oString.orElse("");
    }
}