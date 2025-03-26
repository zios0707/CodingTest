import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 개많네 ㅋㅋㅋㅋㅋ 바로 버퍼리더
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> ls = new ArrayList<>();

        // 대충 저장 로직
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            ls.add(new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }

        // 아래 정렬은 버블 소터. 10만의 값을 처리하기에는 터무니 없이 부족함.
        // [1]을 참조시키게 하고 싶은데 어떻게 하지?
        ls.sort(Comparator.comparing(a -> a[0]));
        ls.sort(Comparator.comparing(a -> a[1]));
        // -> 굿
        
        // + 아 미친 첫번째 원소도 고려해줘야됨 ㅋㅋㅋㅋ
        // 반례
        // 3
        // 5 5
        // 4 4
        // 4 5
        
        Queue<int[]> q = new LinkedList<>(ls);

        int cnt = 0, idx = 0;

        while (!q.isEmpty()) {
            // 미리 정렬 시켜놔서 먼저 뽑아놔도 괜찮음 ㅋㅋ
            idx = q.poll()[1];
            cnt++;
            while (!q.isEmpty() && idx > q.peek()[0]) q.poll();
        }

        System.out.println(cnt);
    }
}

