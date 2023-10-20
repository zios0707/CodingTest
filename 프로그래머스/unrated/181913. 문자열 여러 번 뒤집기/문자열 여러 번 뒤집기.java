class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] charString = my_string.toCharArray();
        for (int[] query:queries) {
            int j = query[1];
            for (int i = query[0]; i < j; i++) {
                char tmp = charString[i];
                charString[i] = charString[j];
                charString[j--] = tmp;
            }
        }
        return String.valueOf(charString);
    }
}