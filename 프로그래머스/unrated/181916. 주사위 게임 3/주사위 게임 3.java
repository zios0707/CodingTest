import java.util.Arrays;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] point = new int[7];
        int count;
        int[] query;
        point[a]++;
        point[b]++;
        point[c]++;
        point[d]++;

        if(point[a] == 4) { // (4)

            count = 4;
            query = new int[]{a, 0};

        }else if(point[a] == 3 || point[b] == 3){ // (3), (1)

            count = 3;
            int index = 0;
            if(point[a] == 1) index = a;
            else if (point[b] == 1) index = b;
            else if (point[c] == 1) index = c;
            else if (point[d] == 1) index = d;
            int sec;

            if (index == a) sec = b;
            else sec = a;
            query = new int[]{index, sec};

        }else if (a == b || a == c || a == d || b == c || b == d || c == d) {
            int[] arr = new int[2];
            if(point[a] == 1 || point[b] == 1 || point[c] == 1) { // 2, (1), (1)
                count = 1;
                int Iter = 0;
                for(int i = 1; i <= 6; i++)
                    if(point[i] == 1) arr[Iter++] = i;
            }else { // (2), (2)
                count = 2;
                if(a == b) arr = new int[]{a, c};
                else arr = new int[]{a, b};

            }
            query = arr;
        }else { // 1, 1, 1, (1) <= 최소값
            count = 0;
            int[] arr = new int[]{a, b, c, d};
            int min = Arrays.stream(arr).min().getAsInt();
            query = new int[]{min, 0};
        }
        // 값 계산은 끝. 이제 정답을 도출하자.
        int result = switch (count) {
            case 0 -> query[0];
            case 1 -> query[0] * query[1];
            case 2 -> (query[0] + query[1]) * Math.abs(query[0] - query[1]);
            case 3 -> (int) Math.pow(10 * query[1] + query[0], 2);
            case 4 -> 1111 * query[0];
            default -> 0;
        };
        System.out.println(count);
        return result;
    }
}