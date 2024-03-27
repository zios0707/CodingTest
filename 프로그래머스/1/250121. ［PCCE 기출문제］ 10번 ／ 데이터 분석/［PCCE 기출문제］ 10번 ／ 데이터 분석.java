
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<DataSet> list = new ArrayList<>();
        for (int[] i : data) list.add(new DataSet(i));
        return list.stream().filter(e -> e.filter(ext, val_ext))
                .sorted(Comparator.comparing(e -> e.getByStandard(sort_by)))
                .map(DataSet::toArray).toArray(int[][]::new);
    }
}

class DataSet {
    int code;
    int date;
    int maximum;
    int remain;

    DataSet(int[] data) {
        this.code = data[0];
        this.date = data[1];
        this.maximum = data[2];
        this.remain = data[3];
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "code=" + code +
                ", date=" + date +
                ", maximum=" + maximum +
                ", remain=" + remain +
                '}';
    }

    public boolean filter(String ext, int val_ext) {
        if(ext.equals("code")) return this.code < val_ext;
        if(ext.equals("date")) return this.date < val_ext;
        if(ext.equals("maximum")) return this.maximum < val_ext;
        return this.remain < val_ext;

    }

    public int getByStandard(String sort_by) {
        if(sort_by.equals("code")) return this.code;
        if(sort_by.equals("date")) return this.date;
        if(sort_by.equals("maximum")) return this.maximum;
        return this.remain;
    }

    public static int[] toArray(DataSet dataSet) {
        return new int[]{dataSet.code, dataSet.date, dataSet.maximum, dataSet.remain};
    }
}