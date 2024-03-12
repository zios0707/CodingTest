import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for (int i = 0; i < o; i++) {
            int H = sc.nextInt(), W = sc.nextInt(), customer = sc.nextInt();
            System.out.printf("%d%02d\n", (customer % H == 0) ? H : (customer % H), (customer - 1) / H + 1);
        }
    }
}