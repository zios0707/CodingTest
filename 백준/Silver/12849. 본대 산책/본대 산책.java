import java.util.*;

public class Main {

    static boolean first = true;
    static long[][] map = new long[2][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map[0][0] = 1;

        int m = sc.nextInt();
        while (m-- > 0) {
            int page = (first) ? 0 : 1;
            int opposite = 1 - page;

            map[opposite][0] = (map[page][1] + map[page][2]) % 1_000_000_007;
            map[opposite][1] = ((map[page][0] + map[page][2]) % 1_000_000_007 + (map[page][3])) % 1_000_000_007;
            map[opposite][2] = ((map[page][0] + map[page][1]) % 1_000_000_007 + (map[page][3] + map[page][4]) % 1_000_000_007) % 1_000_000_007;
            map[opposite][3] = ((map[page][1] + map[page][2]) % 1_000_000_007 + (map[page][4] + map[page][5]) % 1_000_000_007) % 1_000_000_007;
            map[opposite][4] = ((map[page][2] + map[page][3]) % 1_000_000_007 + (map[page][5] + map[page][6]) % 1_000_000_007) % 1_000_000_007;
            map[opposite][5] = ((map[page][3] + map[page][4]) % 1_000_000_007 + (map[page][7])) % 1_000_000_007;
            map[opposite][6] = (map[page][4] + map[page][7]) % 1_000_000_007;
            map[opposite][7] = (map[page][5] + map[page][6]) % 1_000_000_007;

            flip();
        }

        System.out.println(map[(first) ? 0 : 1][0]);
    }
    public static void flip() {
        first = !first;
    }
}
