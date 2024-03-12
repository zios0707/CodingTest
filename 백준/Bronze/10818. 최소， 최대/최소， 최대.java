import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) arr.add(sc.nextInt());
        System.out.printf("%d %d", arr.stream().min(Comparator.comparingInt(Integer::intValue)).get(), arr.stream().max(Comparator.comparingInt(Integer::intValue)).get());
    }
}