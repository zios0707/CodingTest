import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    String[] DISCOUNT;
    List<String> list;
    int[] NUMBER;
    public int solution(String[] want, int[] number, String[] discount) {
        DISCOUNT = discount;
        NUMBER = number;

        list = new ArrayList<>(List.of(want));

        // list.indexOf(String) 의 값이 고유 번호로서 작용

        int count = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            if (canJoin(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean canJoin(int start) {
        int[] counts = new int[list.size()];

        for (int i = start; i < start + 10; i++) {
            if (list.contains(DISCOUNT[i])) {
                counts[list.indexOf(DISCOUNT[i])]++;
            }
        }

        return Arrays.equals(counts, NUMBER);
    }
}