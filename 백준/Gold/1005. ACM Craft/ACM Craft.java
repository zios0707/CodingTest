import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> risks;
    // key (idx) -> value (next nodes) // 정방향
    private static Map<Integer, List<Integer>> edges;
    // key (idx) -> value (pre nodes) // 역방향 // for 건물 설치 여부에 사용
    private static Map<Integer, List<Integer>> reverseEdges;


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Integer[] command;

    private static int target;
    private static int time;

    public static void main(String[] args) throws IOException {
        // 입력으로 받는 인덱스들은 한 수 내려서 계산 <- 그게 편해
        
        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            time = 0;
            edges = new HashMap<>();
            reverseEdges = new HashMap<>();

            load();
            int n = command[1];
            load();
            risks = Arrays.asList(command);
            
            for (int j = 0; j < n; j++) {
                load();
                List<Integer> ls = edges.getOrDefault(command[0] - 1, new ArrayList<>());
                ls.add(command[1] - 1);
                edges.put(command[0] - 1, ls);
                
                ls = reverseEdges.getOrDefault(command[1] - 1, new ArrayList<>());
                ls.add(command[0] - 1);
                reverseEdges.put(command[1] - 1, ls);
            }

            load();
            target = command[0] - 1;

            execute();

            System.out.println(time);

        }

    }

    private static void execute() {
//        System.out.println(risks);
//        System.out.println(edges);
//        System.out.println(reverseEdges);
//        System.out.println("target - " + target);

        List<Integer> WIP = new ArrayList<>();
        for (int i = 0; i < risks.size(); i++) WIP.add(i);
        List<Integer> inBuild = new ArrayList<>();
        List<Integer> completed = new ArrayList<>();
        // 상태를 3개로 나눠서 관리
        // 좀 불편하긴한데 확실한 로직을 위해
        List<Integer> temp;

        while (!completed.stream().anyMatch(i -> i == target)) {
//            System.out.println(WIP);
//            System.out.println(inBuild);
//            System.out.println(completed);
//
//            System.out.println(reverseEdges);

            temp = WIP.stream().filter(node -> reverseEdges.getOrDefault(node, List.of()).isEmpty()).collect(Collectors.toList());

            WIP.removeAll(temp);
            inBuild.addAll(temp);

            inBuild.sort(Comparator.comparing((i) -> risks.get(i)));

            int minIdx = inBuild.get(0);
            int disTime = risks.get(minIdx);

            time += disTime;
            inBuild.forEach(node ->
                    risks.set(node, risks.get(node) - disTime)
            );

            temp= inBuild.stream().filter(node ->
                    risks.get(node) <= 0
            ).collect(Collectors.toList());

            temp.forEach(node ->
                    edges.getOrDefault(node, List.of()).forEach(nextNode ->
                            reverseEdges.get(nextNode).remove(node)
                    )
            );

            inBuild.removeAll(temp);
            completed.addAll(temp);
        }
    }

    private static void load() throws IOException {
        command = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }
}