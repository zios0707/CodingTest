import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int combo = 0, maxCombo = bandage[0], recovery = bandage[1], bigRecovery = bandage[2], maxHealth = health;
        for (int[] i : attacks) map.put(i[0], i[1]);
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if(map.containsKey(i)) {
                combo = 0;
                health -= map.get(i);
            }
            else {
                health += recovery;
                combo++;
                if(combo == maxCombo) {
                    combo = 0;
                    health += bigRecovery;
                }
                if(health >= maxHealth) health = maxHealth;
            }
            if(health <= 0) return -1;
        }
        return health;
    }
}