import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = 0, lbuff = 0, right = -1, main = 666, level = 1, n = sc.nextInt();
        for (int i = 1; i < n; i++) {

            if (right != -1) {
                right++;
                if (level == right) {
                    right = -1;
                    main = 666;
                    left = left * level + lbuff + 1;
                    lbuff = 0;
                    level = 1;
                }
            } else {
                left++;
            }
            while (left % 10 == 6) {
                right = 0;
                level *= 10;
                lbuff = lbuff * 10 + left % 10;
                left /= 10;
                main *= 10;
            }

        }
        System.out.println(left * 1000 * level + ((right == -1) ? main : main + right));
    }
}