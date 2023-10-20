class Solution {
    public String solution(String my_string, int s, int e) {
        char[] charStr = my_string.toCharArray();
        int Iter = e;
        for (int i = s; i < Iter; i++) charStr = swap(charStr ,i ,Iter--);
        return String.valueOf(charStr);
    }

    private char[] swap (char[] str, int index1, int index2) {
        char tmp = str[index1];
        str[index1] = str[index2];
        str[index2] = tmp;
        return str;
    }
}