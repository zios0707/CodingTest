import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int[] alphabets = new int[30];
        int cnt = 0, index = 0;
        sc.next().toLowerCase().chars().forEach(i -> alphabets[i - 'a']++);
        int max = Arrays.stream(alphabets).max().getAsInt();
        for (int i = 0; i < alphabets.length; i++)
            if (alphabets[i] == max) {
                index = i;
                cnt++;
            }
        System.out.println((cnt > 1) ? "?" : (char) (index + 'A'));
    }
}