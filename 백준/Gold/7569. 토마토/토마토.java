import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), changeTMT = 0, livingTMT = 0, days = 1;

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        int[][][] map = new int[a][b][c];

        LinkedList<int[]> queue = new LinkedList<>();

        for (int k = 0; k < c; k++) for (int j = 0; j < b; j++) for (int i = 0; i < a; i++) {
            map[i][j][k] = sc.nextInt();
            if(map[i][j][k] == 1) queue.add(new int[]{i, j, k});
            else if(map[i][j][k] == 0) livingTMT++;
        }

        while(!queue.isEmpty()) {
            int[] location = queue.remove();

            for(int i = 0; i < 6; i++) {
                int x = location[0] + dx[i];
                int y = location[1] + dy[i];
                int z = location[2] + dz[i];

                if(x < 0 || a <= x || y < 0 || b <= y || z < 0 || c <= z) continue;
                else if(map[x][y][z] != 0) continue;
                queue.add(new int[]{x, y, z});
                map[x][y][z] = map[location[0]][location[1]][location[2]] + 1;
                days = Math.max(map[x][y][z], days);
                changeTMT++;
            }
        }
        if(changeTMT != livingTMT) days = 0;
        System.out.println(days - 1);

    }
}