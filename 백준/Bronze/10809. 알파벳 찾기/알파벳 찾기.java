import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] map = new int[26];
        map = Arrays.stream(map).map(a -> a = -1).toArray();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(map[c] == -1) map[c] = i;
        }
        for (int i : map) System.out.printf("%d ", i);
    }
}