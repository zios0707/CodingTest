import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(sc.next());
        for (String s : set.stream().sorted().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList())) System.out.println(s);
    }
}