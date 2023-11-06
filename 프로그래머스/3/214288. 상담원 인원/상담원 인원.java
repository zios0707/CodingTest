import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int[][] map = new int[k][n + 1];

        for(int i = 0; i < k; i++) { // 상담 분야별 모든 경우의 수를 구하기 위해 0 ~ k번 반복
            for(int j = 0; j < n - k + 1; j++) { // 상담사 수(1 ~ 최대가능한 수) 
                Integer spendT = 0;
                boolean chk = false;
                ArrayList<Integer> set = new ArrayList<>();

                for(int[] ii: reqs) {
                    Integer min = 100000;
                    Integer mentors = 0;
                    if(ii[2] != i + 1) continue;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (Integer iii: set) {
                        chk = true;
                        mentors++; 
                        if(iii <= ii[0]) list.add(iii);// 끝나는 시각이 시작 시간보다 같거나 빠를 경우
                        else if(iii < min) min = iii;
                    }
                    if(!chk) set.add(ii[0] + ii[1]);// 진행중 쿼리가 없을 경우
                    else if (list.isEmpty()) { // 진행중 쿼리가 이 쿼리 시작 전에 끝나는게 없는 경우 
                        if(mentors == j + 1) { // 상담사 수 이슈
                            spendT += min - ii[0]; 

                            set.remove(min);
                            set.add(min + ii[1]);

                        }else set.add(ii[0] + ii[1]); // 상담사 수 이슈 없음
                    }else { // 진행중 쿼리가 이 쿼리 시작 전에 끝나는 경우 
                        list.forEach(set::remove);
                        set.add(ii[0] + ii[1]);
                    } 
                } 
                map[i][j] = spendT;
            }
        }
 
        int[] result = new int[k];
        Arrays.fill(result, 1);

        for(int i = 0; i < n - k; i++) {
            Integer[] pointer = new Integer[]{0, 0}; 
            for(int j = 0; j < k; j++) {
                int dif = map[j][result[j] - 1] - map[j][result[j]];
                if(pointer[0] < dif) {
                    pointer[0] = dif;
                    pointer[1] = j;
                }
            } 
            result[pointer[1]]++;
        }

        int answer = 0;
        for (int i = 0; i < k; i++) answer += map[i][result[i] - 1]; 

        return answer;
    } 
}