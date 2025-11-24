import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        do {
            int sim = n%3;
            n = n/3;
            if(sim == 0) n--;
                
            sb.append((sim == 0) ? 4 : sim);
        } while(n > 0);

        return sb.reverse().toString();
    }
}