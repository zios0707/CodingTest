import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int y, x, answer = 33;
        ArrayList<String> map = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt(); x = sc.nextInt();
        for(int i = 0; i < y; i++)
            map.add(sc.next());

        for (int i = 0; i <= x - 8; i++)
            for(int j = 0; j <= y - 8; j++) {
                int fI = i;
                answer = Math.min(answer, calc(map.stream().skip(j).limit(8)
                        .map(e -> e.substring(fI, fI + 8))
                        .collect(Collectors.toUnmodifiableList())));
            }
        System.out.println(answer);
    }

    private static int calc(List<String> map) {
        int Wcount = 0, Bcount = 0;
        for (int i = 0; i < 8; i++) {
            boolean toggle = i % 2 == 0;
            String s = map.get(i);
            for (char c : s.toCharArray()) {
                if (!(toggle == (c == 'W'))) Wcount++;
                if (!(toggle == (c == 'B'))) Bcount++;
                toggle = !toggle;
            }
        }

        return Math.min(Wcount, Bcount);
    }
}