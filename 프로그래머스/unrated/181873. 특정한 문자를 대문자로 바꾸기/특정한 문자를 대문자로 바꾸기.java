class Solution {
    public String solution(String my_string, String alp) {
        return my_string.replace(alp, Character.toString(Character.codePointAt(alp, 0) - 32));
    }
}