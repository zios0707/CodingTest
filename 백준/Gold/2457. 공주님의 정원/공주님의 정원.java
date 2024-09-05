import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(
                    new Pair(
                        getDay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
                        getDay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
                    )
            );
        }

        int cnt = 0;

        int endOfDay = 0;

        for (int i = 60; i <= 334; i++) {
            if (endOfDay <= i) {
                int fI = i;
                Optional<Pair> last = list.stream().filter(p -> p.isIn(fI)).max(Comparator.comparing(Pair::getEnd));

                if (last.isPresent()) {
                    endOfDay = last.get().getEnd();
                    cnt++;
                }else {
                    System.out.println("0");
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int getDay(int month, int day) {
        month--;
        while (month > 0) {

            if (month == 4 || month == 6 || month == 9 || month == 11) day += 30;
            else if (month == 2) day += 28;
            else day += 31;

            month--;
        }

        return day;
    }

    public static class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {return start;}
        public int getEnd() {return end;}

        public boolean isIn(int day) {
            return start <= day && day < end;
        }
    }
}