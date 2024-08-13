class Solution {
    public int solution(int n) {
        int firstOne = Integer.bitCount(n);

        do {
            n++;
        }while(Integer.bitCount(n) != firstOne);

        return n;
    }
}