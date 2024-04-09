import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public boolean solution(String[] phone_book) {
        phone_book = Arrays.stream(phone_book).sorted().toArray(String[]::new);
        boolean tkn = true;
        for (int i = 0; i < phone_book.length - 1; i++)
            if (phone_book[i + 1].startsWith(phone_book[i]))
                tkn = false;
        return tkn;
    }
}