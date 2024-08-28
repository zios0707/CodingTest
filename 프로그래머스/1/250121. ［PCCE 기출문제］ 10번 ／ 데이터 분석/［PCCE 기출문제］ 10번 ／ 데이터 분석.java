import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data).map(Data::new).filter(it -> 
            it.getField(ext) < val_ext
        ).sorted(
            (d1, d2) -> d1.getField(sort_by) - d2.getField(sort_by)
        ).map(Data::toArray).toArray(int[][]::new);
    }
    
    
    class Data {
        int code;
        int date;
        int maximum;
        int remain;

        Data(int[] data) {
            this.code = data[0];
            this.date = data[1];
            this.maximum = data[2];
            this.remain = data[3];
        }

        public int getField(String field) {
            if(field.equals("code")) return code;
            if(field.equals("date")) return date;
            if(field.equals("maximum")) return maximum;
            if(field.equals("remain")) return remain;
            return 0;
        }
        
        public int[] toArray() {
            return new int[]{code, date, maximum, remain};
        }
    }
}
