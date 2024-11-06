import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lim = Integer.parseInt(br.readLine());

        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        String[] buf = br.readLine().split(" ");
        int b = Integer.parseInt(buf[0]), c = Integer.parseInt(buf[1]);
        long acc = 0;

        for (int i : arr) acc += Math.max(((i - b) + c - 1) / c, 0);

        System.out.println(acc + arr.length);
    }
}