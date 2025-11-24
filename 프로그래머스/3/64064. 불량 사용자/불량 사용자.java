import java.util.*;

class Solution {
    private List<boolean[]> banSet = new ArrayList();
    private boolean[] has_banned;
    private boolean[][] banMap;
    private int answer = 0;
    
    public int solution(String[] user_id, String[] banned_id) {
        banMap = new boolean[banned_id.length][user_id.length];
        has_banned = new boolean[user_id.length];
        
        
        for(int i = 0; i < banned_id.length; i++) {
            String s = banned_id[i];
            
            
            for(int j = 0; j < user_id.length; j++) {
                boolean flag = true;
                
                if(s.length() != user_id[j].length()) flag = false;
                if(flag) {
                    String u = user_id[j];
                    
                    for(int c = 0; c < s.length(); c++) if(s.charAt(c) != '*' && s.charAt(c) != u.charAt(c)) {
                        flag = false;
                        break;
                    }
                }
                    
                if(flag) banMap[i][j] = true; 
            }
            
        }
        
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int depth) {
        if(banMap.length == depth) {
            if (banSet.stream().noneMatch((list) -> Arrays.equals(list, has_banned))) {
                banSet.add(has_banned.clone());
                answer++;
            }
            return;
        }
        
        boolean[] map = banMap[depth];
        
        for(int i = 0; i < map.length; i++) if(map[i] && !has_banned[i]) {
            has_banned[i] = true;
            dfs(depth + 1);
            has_banned[i] = false;
        }
    }
}