import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String myString, String pat) {
        return (myString.chars().map((n) -> {
            if (n == 'A') return 'B';
            else return 'A';
        }).mapToObj(Character::toString).collect(Collectors.joining("")).contains(pat)) ? 1 : 0;
    }
}