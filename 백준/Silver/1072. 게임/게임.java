import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextInt(), y = sc.nextInt();

        double beforePer = (y * 100 / (double) x), nowPer;
        long max = Integer.MAX_VALUE / 2 , min = 1;

        while(max != min) {
            long middle = (max + min) / 2;

            nowPer = ((middle + y) * 100 / (double) (middle + x));

            if (Math.floor(nowPer) > Math.floor(beforePer)) max = middle;
            else min = middle + 1;
        }

        if (max == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        }else {
            System.out.println((max + min) / 2);
        }
    }
}
