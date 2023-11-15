import java.util.*;

class Solution {
    public String[] solution(String my_string) {
            ArrayList<String> list = new ArrayList<>();
            String val = "";
            for (char c: my_string.toCharArray()) {
                if (c == ' ') {
                    if (!val.isBlank()) {
                        list.add(val);
                        val = "";
                    }
                } else {
                    val += c;
                }
            }
            if (!val.isBlank()) list.add(val);
            return list.toArray(String[]::new);
    }
}