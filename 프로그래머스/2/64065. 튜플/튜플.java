import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
class Solution {
    public int[] solution(String s) {
        LinkedHashSet<Integer> linkSet = new LinkedHashSet<>();
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(arr, Comparator.comparing(String::length));

        for (String[] ss : Arrays.stream(arr).map(s1 -> s1.split(",")).toArray(String[][]::new)) for (String sss : ss) linkSet.add(Integer.parseInt(sss));
        
        return linkSet.stream().mapToInt(i -> i).toArray();
    }
}