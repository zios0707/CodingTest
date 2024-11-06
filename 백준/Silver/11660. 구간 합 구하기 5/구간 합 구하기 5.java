import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] words = br.readLine().split(" ");

        int len = Integer.parseInt(words[0]);
        int commands = Integer.parseInt(words[1]);
        map = new int[len + 1][len + 1];

        for (int i = 1; i < map.length; i++) {
            words = br.readLine().split(" ");
            for (int j = 1; j < map.length; j++) map[i][j] = Integer.parseInt(words[j - 1]) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
        }

        for (int i = 0; i < commands; i++) {
            int[] indexes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(getPrefix(indexes[0], indexes[1], indexes[2], indexes[3])).append("\n");
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static int getPrefix(int x1, int y1, int x2, int y2) {
        return map[x2][y2] + map[x1-1][y1-1] - map[x1-1][y2] - map[x2][y1-1];
    }
}