import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dump = sc.nextInt(), dump2 = 0;
        int dif = 0;
        for (int i = 0; i < 7; i++) {
            dump2 = sc.nextInt();
            dif = dump - dump2;
            if(Math.abs(dif) != 1) {
                System.out.println("mixed");
                break;
            }
            dump = dump2;
        }
        if(dif == -1) System.out.println("ascending");
        else if(dif == 1)System.out.println("descending");
    }
}