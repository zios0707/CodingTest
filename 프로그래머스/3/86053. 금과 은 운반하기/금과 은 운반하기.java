class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        long low = 0, high = 4_000_000_000_000_000L;

        while(low != high) {
            long mid = (low + high) / 2;
            
            if (!possible(a, b, mid, g, s, w, t)) low = mid + 1;
            else high = mid;

            answer = low;
        }

        return answer;
    }
    
    private boolean possible(int G, int S, long middle, int[] g, int[] s, int[] w, int[] t) {
        boolean flag = false;

        long total_G = 0;
        long total_S = 0;
        long total_SUM = 0;

        for(int i = 0; i < t.length; i++) {
            long trip = (middle + t[i]) / (2L * t[i]);
            long total_del = trip * w[i];
            
            long max_G = Math.min(total_del, g[i]);
            long max_S = Math.min(total_del, s[i]);
            long max_SUM = Math.min(total_del, g[i] + s[i]);
            
            total_G += max_G;
            total_S += max_S;
            total_SUM += max_SUM;
        }

        
        return total_G >= G && total_S >= S && total_SUM >= (long) G + S;
    }
}