import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int temp = 0;
        for (int i = 0; i < L; i++)
            temp += i;
        for (int i = L; ; i++) {
            if(temp > N || i > 100) {
                System.out.print(-1);
                return;
            }
            if((N - temp) % i == 0) {
                for (int j = 0; j < i; j++)
                    System.out.printf("%d ", (N - temp) / i + j);
                break;
            }
            temp += i;
        }
    }
}