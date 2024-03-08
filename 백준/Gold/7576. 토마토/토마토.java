import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), changeTMT = 0, livingTMT = 0, days = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] map = new int[a][b];

        LinkedList<int[]> queue = new LinkedList<>();

        for (int j = 0; j < b; j++) for (int i = 0; i < a; i++) {
            map[i][j] = sc.nextInt();
            if(map[i][j] == 1) queue.add(new int[]{i, j});
            else if(map[i][j] == 0) livingTMT++;
        }

        while(!queue.isEmpty()) {
            int[] location = queue.remove();

            for(int i = 0; i < 4; i++) {
                int x = location[0] + dx[i];
                int y = location[1] + dy[i];

                if(x < 0 || a <= x || y < 0 || b <= y) continue;
                else if(map[x][y] != 0) continue;
                queue.add(new int[]{x, y});
                map[x][y] = map[location[0]][location[1]] + 1;
                days = Math.max(map[x][y], days);
                changeTMT++;
            }
        }
        if(changeTMT != livingTMT) days = 0;
        System.out.println(days - 1);

    }
}