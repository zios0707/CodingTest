import java.util.ArrayList;
import java.util.List;
class Solution {
    
    // n = 진수, t = 구할 갯수, m = 사람 수, p = 자신의 순번
    char[] scales = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (sb.length() <= t * m) {
            sb.append(getStringByScale(n, count++));
        }

        char[] charArr = sb.toString().toCharArray();
        sb = new StringBuilder();
        for (int i = p - 1; sb.length() != t; i += m) {
            sb.append(charArr[i]);

        }

        return sb.toString();
    }

    private StringBuilder getStringByScale(int scale, int value) {
        if (value == 0) return new StringBuilder().append('0');
        List<Integer> values = new ArrayList<>();
        while (value > 0) {
            values.add(value % scale);
            value /= scale;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = values.size() - 1; i >= 0; i--) sb.append(scales[values.get(i)]);

        return sb;
    }
}