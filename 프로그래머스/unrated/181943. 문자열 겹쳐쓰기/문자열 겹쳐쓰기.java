class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String s1 = my_string.substring(s);
        String s2 = my_string.substring(s + overwrite_string.length());
        my_string = my_string.replace(s1, overwrite_string);
        System.out.println(my_string);
        System.out.println(s1);
        return my_string + s2;
    }
}