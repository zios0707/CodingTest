import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("a", " ").replaceAll("b", " ").replaceAll("c", " ");
        if(myStr.isBlank()) return new String[]{"EMPTY"};
        return Arrays.stream(myStr.split(" ")).filter(n -> !n.isBlank()).toArray(String[]::new);
    }
}