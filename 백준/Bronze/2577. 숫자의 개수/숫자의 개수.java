import java.util.Scanner;
public class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int[] map = new int[10];
        String.valueOf(a * b * c).chars().map(s -> s - '0').forEach(it -> map[it]++);
        for (int i : map) System.out.println(i);
    }
}