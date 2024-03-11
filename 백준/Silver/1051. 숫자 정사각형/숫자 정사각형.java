import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt(), a = sc.nextInt();


        int[][] map = new int[a][b];

        int results = 1;

        for(int j = 0; j < b; j++) {
            char[] line = sc.next().toCharArray();

            for (int i = 0; i < a; i++) {
                map[i][j] = line[i] - '0';
            }

        }

        for(int j = 0; j < b - 1; j++)
            for (int i = 0; i < a - 1; i++) {
                int num = map[i][j], length;

                for (int k = 1; ; k++) {
                    length = k;

                    if(length + i >= a ||
                    length + j >= b) break;

                    if(map[i + length][j] == num &&
                    map[i + length][j + length] == num &&
                    map[i][j + length] == num) results = Math.max(results, (length + 1) * (length + 1));

                }
            }

        System.out.println(results);

    }
}