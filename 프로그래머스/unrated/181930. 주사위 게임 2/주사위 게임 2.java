class Solution {
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        int a1 = a * a;
        int a2 = a1 * a;
        int b1 = b * b;
        int b2 = b1 * b;
        int c1 = c * c;
        int c2 = c1 * c;
        if(a == b && b == c) answer *= (a1 + b1 + c1) * (a2 + b2 + c2);
        else if(a != b && b != c && a != c) {}
        else answer *= a1 + b1 + c1;
        return answer;
    }
}