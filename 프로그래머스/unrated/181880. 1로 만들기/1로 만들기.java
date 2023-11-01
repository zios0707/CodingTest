class Solution {
    public int[] memo = new int[31];
    public int solution(int[] num_list) {
        int cnt = 0;
        for(int i : num_list) {
            memo[i] = execute(i);
            cnt += memo[i];
            System.out.println(cnt);
        }
        return cnt;
    }

    public int execute(int i) {
        if(i == 1) return 0;
        else if(memo[i] == 0) {
            if(i % 2 == 0) i /= 2;
            else i = (i - 1) / 2;
            return execute(i) + 1;
        }else return memo[i];
    }
}