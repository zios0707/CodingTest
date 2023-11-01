
import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        int[] save;
        int cnt = 0;
        do {
            save = arr.clone();
            for(int i = 0; i < arr.length; i++)
                if (50 <= arr[i] && arr[i] % 2 == 0) arr[i] /= 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) arr[i] = arr[i] * 2 + 1;
            cnt++;
        }while (!Arrays.equals(save, arr));


        return cnt - 1;
    }
}