import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 1 + j; i++) System.out.print("*");
            System.out.println();
        }
    }
}