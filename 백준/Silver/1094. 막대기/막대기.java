import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.stream(Integer.toBinaryString(sc.nextInt()).split("")).filter((s) -> s.equals("1")).count());
    }
}