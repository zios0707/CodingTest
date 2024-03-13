import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s;
        while(n != 0) {
            s = Integer.toString(n);
            boolean token = true;
            for (int i = 0; i < s.length() / 2; i++) if(s.charAt(i) != s.charAt(s.length() - i - 1)) token = false;
            System.out.println((token) ? "yes" : "no");
            n = sc.nextInt();
        }
    }
}