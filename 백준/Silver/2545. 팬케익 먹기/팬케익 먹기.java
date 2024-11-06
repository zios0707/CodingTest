import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            br.readLine();
            Integer[] ls = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            long a = ls[0], b = ls[1], c = ls[2], d = ls[3];

            while(d != 0) {
                d--;
                long max = Math.max(a, Math.max(b, c));

                if (a == max) a--;
                else if (b == max) b--;
                else c--;
            }

            BigInteger bi = BigInteger.valueOf(a);

            sb.append(bi.multiply(BigInteger.valueOf(b).multiply(BigInteger.valueOf(c)))).append("\n");
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}