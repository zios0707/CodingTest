import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger result = new BigInteger(String.valueOf(0));
        int aOffset = (a.length() < b.length()) ? b.length() - a.length() : 0;
        int bOffset = (a.length() > b.length()) ? a.length() - b.length() : 0;
        for (int i = 0; i < Integer.max(a.length(), b.length()); i++) {
            result = result.multiply(BigInteger.valueOf(Long.parseLong("10")));
            if(i >= aOffset) result = result.add(BigInteger.valueOf(a.charAt(i - aOffset) - '0'));
            if(i >= bOffset) result = result.add(BigInteger.valueOf(b.charAt(i - bOffset) - '0'));
        }

        return result.toString();
    }
}