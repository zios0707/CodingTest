import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int o = Integer.parseInt(sc.next()), count = 0;
        long facto = 1;

        for (int i = 1; i <= o; i++) {
            facto *= i;
            while(facto % 10 == 0) {
                facto /= 10;
                count++;
            }
            facto %= 10000000000L;
        }
        System.out.println(count);
    }
}
