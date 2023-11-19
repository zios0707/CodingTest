
import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();

    public int solution(int N, int number) {
        list.add(new int[]{});
        list.add(new int[]{N});
        if(N == number) return 1;
        for(int i = 2; i <= 9; i++) {
            HashSet<Integer> save = new HashSet<>();
            for(int j = 1; j < i; j++) { 
                for (int n: list.get(j)) {
                    for(int m: list.get(i - j)) {
                        save.add(n + m);
                        save.add(n - m);
                        save.add(n * m); 
                        if(m != 0) save.add(n / m);  
                    }
                } 
            }

            String s = "";
            for (int n = 0; n < i; n++) s += Integer.toString(N);
            save.add(Integer.parseInt(s)); 

            list.add(save.stream().mapToInt(Integer::intValue).toArray());
            if(save.stream().anyMatch(n -> n == number)) return i;
        }
        return -1;
    }
}