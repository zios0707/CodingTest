import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>(); nums.add(-1);
        for (int i = 0 ; i < 9; i++) nums.add(sc.nextInt());
        System.out.println(nums.stream().max(Comparator.comparing(Integer::intValue)).get());
        System.out.println(nums.indexOf(nums.stream().max(Comparator.comparing(Integer::intValue)).get()));
    }
}