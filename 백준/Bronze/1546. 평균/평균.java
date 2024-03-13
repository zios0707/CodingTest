import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) list[i] = sc.nextInt();
        double max = Arrays.stream(list).max().getAsInt();
        System.out.println(Arrays.stream(list).mapToDouble(it -> it / max * 100).average().getAsDouble());
    }
}