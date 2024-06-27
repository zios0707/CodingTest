import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] map = new int[n];
        
        Arrays.fill(map, 1);
        
        for(int i : lost) map[i - 1]--;
        for(int i : reserve) map[i - 1]++;
        
        
        int[] dx = {-1, 1};
        for(int i = 0; i < n; i++) {
            int val = map[i];
            
            if (val > 1) {
                for(int j = 0; j < 2; j++) {
                    int x = i + dx[j];
                    
                    if(0 <= x && x < n && map[x] == 0) {
                        map[x]++;
                        map[i]--;
                        
                        break;
                    }
                }
            }
        }
        
        return (int) Arrays.stream(map).filter((i) -> i > 0).count();
    }
}