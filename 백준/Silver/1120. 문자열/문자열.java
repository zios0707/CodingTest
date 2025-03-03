import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        String A = temp[0], B = temp[1];
        int diff = B.length() - A.length(), max = 51;
        
        for(int i = 0; i <= diff; i++) {
            int cnt = 0;
            for(int j = 0; j < A.length(); j++) if(A.charAt(j) != B.charAt(j + i)) cnt++;
            max = Math.min(max, cnt);
        }
        
        System.out.println(max);
    }
}