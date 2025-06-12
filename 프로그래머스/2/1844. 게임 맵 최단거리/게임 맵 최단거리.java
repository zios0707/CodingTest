import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int min = -1;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<Pair> q = new LinkedList();
        
        q.add(new Pair(0, 0, 1));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            int x = p.x, y = p.y;
                
            if(0<= x && x < maps.length && 0 <= y && y < maps[0].length && !visited[x][y] && maps[x][y] == 1) {
                visited[x][y] = true;
                
                if (x == maps.length - 1 && y == maps[0].length - 1) {
                    min = (min != -1) ? Math.min(p.cnt, min) : p.cnt;
                    
                    System.out.println(p.cnt);
                }
                
                for(int i = 0; i < 4; i++) {
                    x = p.x + dx[i]; y = p.y + dy[i];
                    
                    q.add(new Pair(x, y, p.cnt + 1));
                }
            }
        }
        
        return min;
    }
    
    private static class Pair{
        int x;
        int y;
        int cnt;
        
        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}