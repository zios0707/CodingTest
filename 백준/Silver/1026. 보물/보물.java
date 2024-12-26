import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), result = 0;

        sc.nextLine();

        int[] a, b;

        a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) result += a[i] * b[n - 1 - i];

        System.out.println(result);
    }
}