import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static int X;
    static int Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] query = br.readLine().split(" "), saveQuery = new String[]{};

        int x = Integer.parseInt(query[0]), y = Integer.parseInt(query[1]), n, xn, yn;
        X = x; Y = y;
        int[][] map = new int[x][y];

        for (int i = 1; i <= 3; i++) {

            query = br.readLine().split(" ");
            if(i == 1) saveQuery = query;
            n = Integer.parseInt(query[0]);
            for (int j = 1; j <= n * 2; j += 2) {
                xn = Integer.parseInt(query[j]) - 1; yn = Integer.parseInt(query[j + 1]) - 1;
                map[xn][yn] = i;
                if(i == 2) { // knight
                    int[] dx = {1, 2, -1, -2, -1, -2, 1, 2};
                    int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
                    for (int k = 0; k < 8; k++) {
                        int xa = xn + dx[k];
                        int ya = yn + dy[k];
                        if (isValid(xa, ya) && map[xa][ya] == 0) {
                            map[xa][ya] = -1;
                        }
                    }
                }
            }
        }
        n = Integer.parseInt(saveQuery[0]);
        for (int i = 1; i <= n * 2; i += 2) { // queen
            xn = Integer.parseInt(saveQuery[i]) - 1; yn = Integer.parseInt(saveQuery[i + 1]) - 1;

            int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

            for (int j = 0; j < 8; j++) {
                int xa = xn + dx[j];
                int ya = yn + dy[j];
                while(isValid(xa, ya) && map[xa][ya] <= 0) {
                    map[xa][ya] = -1;
                    xa += dx[j];
                    ya += dy[j];
                }
            }
        }

//        for (int[] i : map) {                 // 출력 //
//            for (int ii : i) {
//                System.out.print(ii + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Arrays.stream(map).flatMapToInt(IntStream::of).filter(a -> a == 0).count());
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < X && 0 <= y && y < Y;
    }
}