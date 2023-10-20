import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        Integer length = a.length();

        for(int i = 0; i < length; i++) {
            char c = a.charAt(i);
            String s1 = String.valueOf(c);

            if(s1.equals(s1.toUpperCase())) {
                // 대문자니까 소문자로 바꾸죠
                result += s1.toLowerCase();
            }else {
                // 소문자니까 대문자로 바꾸죠
                result += s1.toUpperCase();
            }
        }
        System.out.println(result);
        
    }
}