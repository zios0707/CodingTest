import java.io.*;
import java.util.Arrays;

public class Main {
    static int BLURAY;
    static int[] VALS;
    static int[] SUM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BLURAY = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];

        VALS = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        SUM = new int[BLURAY];

        int low = Arrays.stream(VALS).max().getAsInt(), high = Arrays.stream(VALS).sum(), prime = high;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (decision(middle)) {
                prime = Math.min(prime, middle);
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }

        System.out.println(prime);
    }

    private static boolean decision(int maxValue) {
        int cnt = 0;
        int temp = 0;

        for (int i : VALS) {
            if (temp + i > maxValue) {temp = 0; cnt++;}
            temp += i;
        }

        if (temp > maxValue) cnt++;
        return BLURAY > cnt;
    }
}