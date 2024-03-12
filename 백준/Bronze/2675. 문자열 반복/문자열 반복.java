import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int n = sc.nextInt();
            for (String s : sc.next().split(""))
                for (int j = 0; j < n; j++) System.out.print(s);
            System.out.println();
        }
    }
}