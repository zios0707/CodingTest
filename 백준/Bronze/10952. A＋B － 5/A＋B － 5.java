import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, sum;
        while(true) {
            a = sc.nextInt(); b = sc.nextInt(); sum = a + b;
            if(sum == 0) break;
            else System.out.println(sum);
        }
    }
}