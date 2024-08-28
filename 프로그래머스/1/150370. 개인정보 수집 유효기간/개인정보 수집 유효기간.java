import java.util.*;
import java.util.stream.IntStream;

class Solution {
    String dotRgx = "\\.";
    
    Map<String, Integer> map = new HashMap<>();
    List<Integer> answer = new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        for(String s : terms) map.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
        for(int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            
            String date = privacy.split(" ")[0], type = privacy.split(" ")[1];
            String nextDate = addMonth(date.split(dotRgx)[0], date.split(dotRgx)[1], type) + "." + date.split(dotRgx)[2];
            
            if (isExpired(today, nextDate)) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private String addMonth(String year, String month, String type) {
        int term = map.get(type);
        int imonth = Integer.parseInt(month);
        int iyear = Integer.parseInt(year);
        
        if(imonth + term > 12) return (iyear + 1) + "." + (imonth + term - 12);
        return iyear + "." + (imonth + term);
    }
    
    private boolean isExpired(String d1, String d2) {
        int[] ds1 = Arrays.stream(d1.split(dotRgx)).mapToInt(Integer::parseInt).toArray();
        int[] ds2 = Arrays.stream(d2.split(dotRgx)).mapToInt(Integer::parseInt).toArray();
    
        return dateToInt(ds1) >= dateToInt(ds2);
    }
    
    private int dateToInt(int[] date) {
        return (date[0] * 12 + date[1]) * 28 + date[2];
    }
}