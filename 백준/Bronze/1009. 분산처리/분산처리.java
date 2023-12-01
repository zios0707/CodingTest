import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ii = sc.nextInt();
        for (int i = 0; i < ii; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int result = 1;
            for (int j = 0; j <= (b + 3) % 4; j++) result = (result * a % 10) % 10;
            System.out.println((result == 0) ? 10 : result);
        }
    }
}