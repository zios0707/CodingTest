import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] cards) {
        List<Integer> scores = new ArrayList<>();
        boolean[] visited = new boolean[cards.length];
        
        int ptr = 0, stopTo = 0, cnt = 0;
        while(cnt < cards.length) {
            
            while(ptr < cards.length && visited[ptr]) stopTo = ++ptr;
            
            int group_score = 0;
            do {
                visited[ptr] = true;
                ptr = cards[ptr] - 1;
                
                cnt++;
                group_score++;
            } while(ptr != stopTo);
            
            scores.add(group_score);
        }
        
        
        scores = scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toUnmodifiableList());
        
        if(scores.size() <= 1) return 0;
        return scores.get(0) * scores.get(1);
    }
}