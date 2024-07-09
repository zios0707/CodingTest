import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        List<Double> sizes = new ArrayList<>();

        double[] result = new double[ranges.length];

        int n = 0;
        while(k != 1) {
            list.add(k);

            n++;
            if(k % 2 == 0) {
                k /= 2;
            }else {
                k = k * 3 + 1;
            }
        }
        list.add(1);

        for (int i = 0; i < n; i++) sizes.add((double) (list.get(i) + list.get(i + 1)) / 2);


        int cnt = 0;
        for (int[] i : ranges) {
            double sum = 0;
            if (i[0] - i[1] > n) {
                result[cnt++] = -1.0;
                continue;
            }
            for (int j = i[0]; j < n + i[1]; j++) {
                sum += sizes.get(j);
            }
            result[cnt++] = sum;
        }

        return result;
    }
}