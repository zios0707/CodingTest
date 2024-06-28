import java.util.Stack;


class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] chars = number.toCharArray();
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < number.length(); i++) {
            char c = chars[i];
            
            while(count < k && ((s.size() != 0) ? c - '0' - s.peek() : -999) > 0) {
                s.pop();
                count++;
            }
            
            if(i == number.length() - 1 && count != k) while(count < k - 1) s.pop();
            else s.push(c - '0');
        }
        
        for(Integer i: s) sb.append(i);
        
        
        return sb.toString();
    }
}