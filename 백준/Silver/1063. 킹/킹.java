import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] idx = new int[2][2];

        for (int i = 0; i < 2; i++) {
            String s = sc.next();

            idx[i][0] = s.charAt(0) - 'A'; idx[i][1] = s.charAt(1) - '0' - 1;
        }

        for (int i = sc.nextInt(); i > 0; i--) {
            String s = sc.next();

            int x = idx[0][0], y = idx[0][1];

            if (s.contains("R")) x++;
            if (s.contains("L")) x--;
            if (s.contains("B")) y--;
            if (s.contains("T")) y++;

            if (x < 0 || 7 < x || y < 0 || 7 < y) continue;

            int rx = idx[1][0] + x - idx[0][0], ry = idx[1][1] + y - idx[0][1];

            if (x == idx[1][0] && y == idx[1][1]) {
                if (0 <= rx && rx < 8 && 0 <= ry && ry < 8) {
                    idx[1][0] = rx; idx[1][1] = ry;
                    idx[0][0] = x; idx[0][1] = y;
                }
            }else {
                idx[0][0] = x; idx[0][1] = y;
            }
        }

        System.out.println((char) ('A' + idx[0][0]) + "" + (idx[0][1] + 1));
        System.out.println((char) ('A' + idx[1][0]) + "" + (idx[1][1] + 1));
    }
}