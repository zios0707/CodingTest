class Solution {
    public int solution(String[] order) {
        int ameri = 0, latte = 0;
        
        for(String s : order) {
            if(s.contains("latte")) latte++;
            else ameri++;
        }
        
        return ameri * 4500 + latte * 5000;
    }
}