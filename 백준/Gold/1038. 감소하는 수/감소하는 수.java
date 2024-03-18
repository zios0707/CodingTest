import java.util.*;

public class Main {
    static String[] map = new String[]{"0","1","2","3","4","5","6","7","8","9"};
    static int count = -1;
    static int target;
    static String that = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        for (int i = 1; i <= 11; i++) {
            exe(i, i, 10);
        }
        if(target > count) that = "-1";
        System.out.println(that);
    }

    private static void exe(int level, int thisLev, int top) {
        if(level == 0) return;
        for (int i = level - 1; i < top; i++) {
            if(count == target) return;
            that = that.substring(0, thisLev - level) + map[i];
            exe(level - 1, thisLev, i);
            if(level == 1) {
                count++;
            }
        }
    }
}