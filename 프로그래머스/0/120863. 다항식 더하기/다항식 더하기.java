class Solution {
    public String solution(String polynomial) {
        String[] list = polynomial.split(" ");
        int x = 0, integer = 0;
        for (String s: list) {
            if (s.equals("+")) {continue;}
            else if (s.contains("x")) x += (s.length() == 1) ? 1 : Integer.parseInt((s).substring(0, s.indexOf('x')));
            else integer += Integer.parseInt(s);
        }

        return ((x > 0) ? ((x > 1) ? x : "") + "x" : "") + ((x > 0 && integer > 0) ? " + " : "") + (integer > 0 ? integer : "");
    }
}