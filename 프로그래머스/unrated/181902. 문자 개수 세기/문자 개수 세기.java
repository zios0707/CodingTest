class Solution {
    public int[] solution(String my_string) { 
        int[] answer = new int[52];

        for(char c: my_string.toCharArray()) {
            int num = 0;
            if(97 <= c && c <= 122) {
                num += 26;
                c -= 32;
            }
            num += c - 65;
            answer[num] += 1;
        }

        for(int i: answer) {
            System.out.println(i);
        }
        return answer;
    }
}