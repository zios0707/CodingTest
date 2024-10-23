import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken()), count = Integer.parseInt(st.nextToken());
        int[] lans = new int[length];
        for (int i = 0; i < length; i++) lans[i] = Integer.parseInt(br.readLine());
        Arrays.sort(lans);

        long low = 1, top = lans[lans.length - 1], middle = 0, prime = middle;

        while(low <= top) {
            middle = (low + top) / 2;

            long cnt = 0;
            for (int len: lans) cnt += len / middle;

            if (cnt >= count) {
                prime = Math.max(prime, middle);
                low = middle + 1;
            }
            else top = middle - 1;
        }
        System.out.println(prime);
    }
}