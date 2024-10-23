import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[][] map;
    static boolean[][] isDefined;
    static int[] palindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        palindrome = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new boolean[palindrome.length][palindrome.length];
        isDefined = new boolean[palindrome.length][palindrome.length];

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int[] pair = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            bw.write(search(pair[0] - 1, pair[1] - 1) ? "1" : "0");
            bw.newLine();
        }
        bw.flush();
    }

    private static boolean search(int left, int right) {
        if (isDefined[left][right]) return map[left][right];

        if (right - left <= 1 || search(left + 1, right - 1))
            if (check(left, right)) return setStatus(left, right, true);
            else return setStatus(left, right, false);
        else return setStatus(left, right, false);
    }

    private static boolean setStatus(int left, int right, boolean status) {
        isDefined[left][right] = true;
        return map[left][right] = status;
    }

    private static boolean check(int left, int right) {
        while(left < right) {
            if (palindrome[left] != palindrome[right]) return false;
            left++; right--;
        }

        return true;
    }
}