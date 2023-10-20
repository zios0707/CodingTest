class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        for(Integer i: num_list) {
            if(i % 2 == 0) even += String.valueOf(i);
            else odd += String.valueOf(i);
        }
        answer = Integer.parseInt(even) + Integer.parseInt(odd);
        return answer;
    }
}