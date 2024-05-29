import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] list = new int[n]; // 원형 상태의 배열임.
        for (int i = 0; i < n; i++) list[i] = i + 1;

        Set<String> map = new HashSet<>();

        String lastWord = null;

        for (int i = 0; i < words.length; i++) {
            String thisWord = words[i];
            
            if(map.contains(thisWord) || (lastWord != null && !thisWord.startsWith(lastWord))) {
                return new int[]{list[i % n], i / n + 1};
            }else {
                lastWord = thisWord.substring(thisWord.length() - 1);
                map.add(thisWord);
            }
        }
        return new int[]{0, 0};
    }
}