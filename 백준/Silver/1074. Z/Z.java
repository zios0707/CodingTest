import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(), y = sc.nextInt(), x = sc.nextInt(), dx, dy, point = 1, score = 0, scale = 1;
        boolean tkn = true;
        for (int i = 0; i < w - 1; i++) {
            point *= 4;
            scale *= 2;
        }


        while (tkn) { 
            if(point == 0) {
                tkn = !tkn;
                continue;
            }
            dx = x / scale; dy = y / scale; 
            scale /= 2;
            if(dx == 1) {
                x -= (int) Math.sqrt(point);
                score += point; 
            }
            if(dy == 1) {
                y -= (int) Math.sqrt(point);
                score += point * 2; 
            }
            point /= 4;
        }
        System.out.println(score);
    }
}