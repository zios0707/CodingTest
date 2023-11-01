class Solution {
    public int solution(int[] num_list) {
        boolean coin = true;
        int even = 0, odd = 0;
        for (int i: num_list) {
            if(coin) even += i;
            else odd += i;
            coin = !coin;
        }
        return (even > odd) ? even : odd;
    }
}