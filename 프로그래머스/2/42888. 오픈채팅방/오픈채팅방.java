import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : record) {
            String[] data = s.split(" ");
            String command = data[0];
            String id = data[1];
            // Leave 는 data[2]에 접근 불가이기에 지금 선언 안함

            if (command.equals("Enter") || command.equals("Change")) nameMap.put(id, data[2]);
        }

        for (String s : record) {
            if (s.startsWith("Change")) continue;
            String[] data = s.split(" ");
            String command = data[0];
            String id = data[1];
            list.add(nameMap.get(id) + (command.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다."));
        }


        return list.toArray(String[]::new);
    }
}