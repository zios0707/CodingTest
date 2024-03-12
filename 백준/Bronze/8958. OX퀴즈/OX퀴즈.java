import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (String s : sc.next().split("X")) for (int j = 1; j <= s.length(); j++) result += j;
            System.out.println(result);
        }
    }
}