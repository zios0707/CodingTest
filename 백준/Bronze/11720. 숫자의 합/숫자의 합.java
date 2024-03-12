import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), result = 0;
        for (String s :  sc.next().split("")) result += s.charAt(0) - '0';
        System.out.println(result);
    }
}