
class Solution {
    public int solution(int n) {
        int cnt = 0, temp = 0, val;

        while (++temp != n + 1) {
            val = 0;

            for (int i = temp; val < n; i++) val += i;

            if (val == n) cnt++;
        }
        
        return cnt;
    }
}