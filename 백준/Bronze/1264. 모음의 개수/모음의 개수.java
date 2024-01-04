import java.util.*; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String s = sc.nextLine();
            if(s.equals("#")) break;
            System.out.println(s.toLowerCase().chars().boxed().filter(e -> {
                return e == 'a' ||
                        e == 'e' ||
                        e == 'i' ||
                        e == 'o' ||
                        e == 'u';
            }).count());
        }
    }
}