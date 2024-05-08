class Solution {
    public int[] solution(int brown, int yellow) {
        int i = 3, j = 3, flag = 0;
        for (j = 3; j < 2499; j++) {
            for (i = 3; i <= j; i++) {
                int innerSize = (i - 2) * (j - 2);
                int outerSize = i * j - innerSize;
                
                if(brown == outerSize &&
                  yellow == innerSize) {
                    flag = 1;
                    break;
                }
                
            }
            if (flag == 1) break;
        }
        return new int[]{j, i};
    }
}   