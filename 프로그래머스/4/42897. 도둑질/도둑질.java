class Solution {
    int[][] arrs;
    int[][] memos;
    public int solution(int[] money) {
        memos = new int[2][money.length];
        trimArray(money);

        int[] result = new int[2];
        for (int n = 0; n < 2; n++) {
            int[] arr = arrs[n];
            int[] memo = memos[n];
            System.arraycopy(arr, 0, memo, 0, 2);
            for (int index = 2; index < money.length; index++) if(memo[index] == 0) memo[index] = Math.max(memo[index - 1], memo[index - 2] + arr[index]);
            result[n] = memos[n][money.length - 1];
        }

        return Math.max(result[0], result[1]);
    }

    private void trimArray(int[] arr) {
        int[] newArr1 = new int[arr.length];
        int[] newArr2 = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            newArr1[i] = arr[i - 1];
            newArr2[i] = arr[i];
        }
        arrs = new int[][]{newArr1, newArr2};
    }
}