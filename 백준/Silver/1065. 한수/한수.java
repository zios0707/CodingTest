import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0, n = sc.nextInt();

        for (int i = n; i >= 100; i--) {
            int[] ls = new int[3];
            int t = i;
            ls[0] = t / 100;
            ls[1] = (t % 100) / 10;
            ls[2] = t % 10;

            if (ls[0] - ls[1] == ls[1] - ls[2]) cnt++;
        }

        System.out.println(cnt + ((n < 100) ? n : 99));
    }
}