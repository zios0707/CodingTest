import java.util.Arrays;

class Solution {
    int max = 0;
    int[][] DUNGEONS;
    boolean[] ways;

    public int solution(int k, int[][] dungeons) {
        ways = new boolean[dungeons.length];
        Arrays.fill(ways, true);
        DUNGEONS = dungeons;

        search(k, 0);

        return max;
    }

    public void search(int stamina, int depth) {
        if (depth > max) max = depth;

        for (int i = 0; i < ways.length; i++) if(ways[i] && DUNGEONS[i][0] <= stamina) {
            ways[i] = false;
            search(stamina - DUNGEONS[i][1], depth + 1);
            ways[i] = true;
        }
    }
}