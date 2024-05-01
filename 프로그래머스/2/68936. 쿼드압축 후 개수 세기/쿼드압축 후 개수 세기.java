class Solution {
    int zero;
    int one;
    int n;
    int[][] array;


    public int[] solution(int[][] arr) {
        zero = 0;
        one = 0;
        n = 0;
        array = arr;
        n = getSquare(arr.length);
        int val = cal(0, 0, n);
        if(val == 1) one++;
        else if(val == 0) zero++;

        return new int[]{zero, one};

    }

    // returns : -1, 0, 1
    // -1 은 값이 복잡하다는 뜻. 1은 truthy, 0은 falsy 로도 해석
    private int cal(int x, int y, int N) {
        if(N == 0) return (array[x][y] == 1) ? 1 : 0;
        int radix = getNumberBySquare(N - 1);
        int[] radixX = new int[]{x, x + radix, x, x + radix};
        int[] radixY = new int[]{y, y, y + radix, y + radix};
        int isEquals = 0;
        int[] saveList = new int[4];

        for(int i = 0; i < 4; i++) {
            int val = cal(radixX[i], radixY[i], N - 1);
            saveList[i] = val;
            isEquals += (val != -1) ? (val == 1) ? 1 : -1 : 0;
            // 0 인 경우 내부에서 이탈이 있다는 뜻 -> 절대 4, -4가 되지 못함
            // 서로 다른 수가 영역 내에서 블럭씩으로 묶어진다해도 1, -1이 있어 4, -4가 되지 못함
        }

        if(isEquals % 4 == 0 && isEquals != 0) { // n ^ N 크기의 블럭이 하나로 묶을 수 있는 상태
            return (isEquals == 4) ? 1 : 0;
        }else {
            for(int i: saveList) {
                if(i == 1) one++;
                else if(i == 0) zero++;
            }
            return -1;
        }
    }

    private int getNumberBySquare(int N) {
        int i = 1;
        for(int j = 1; j <= N; j++) i *= 2;
        return i;
    }

    private int getSquare(int m) {
        int N = 0;
        for(int i = 1; i < m; i *= 2) N += 1;
        return N;
    }
}