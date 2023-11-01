import java.util.ArrayList;

class Solution {
    public String[] solution(String[] str_list) {

        String str_one = String.join("", str_list);

        ArrayList<Character> left = new ArrayList<>();
        ArrayList<Character> right = new ArrayList<>();

        Boolean tkn = false;
        Character ch = '!';

        if(!(str_one.contains("l") || str_one.contains("r"))) return new String[]{};

        for(char c: str_one.toCharArray()){


            System.out.println(ch);
            System.out.println(c);
            if (ch == '!') {
                if (c == 'r') {
                    tkn = true;
                    ch = 'r';
                    continue;
                } else if (c == 'l') {
                    tkn = true;
                    ch = 'l';
                    continue;
                }
            }

            if(tkn) right.add(c); // 오른쪽
            else left.add(c);// 왼쪽
        }

        int n = 1;

        if(ch == 'r') n = right.size();
            else n = left.size();

        String[] result = new String[n];

        if(ch == 'r') for (int i = 0; i < n; i++) result[i] = String.valueOf(right.get(i));
            else for (int i = 0; i < n; i++) result[i] = String.valueOf(left.get(i));

        return result;

    }
}