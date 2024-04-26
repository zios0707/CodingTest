import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int[] intchars = new int[chars.length];
        for (int i = 0; i < chars.length; i++) intchars[i] = chars[i];
        intchars = Arrays.stream(intchars).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        for (int i = 0; i < chars.length; i++) chars[i] = (char) intchars[i];
        return String.copyValueOf(chars);
    }
}