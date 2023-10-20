class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length - 1;
        int[] array = new int[length + 2];
        System.arraycopy(num_list, 0, array, 0, num_list.length);
        if (num_list[length] > num_list[length - 1]) {
            array[length + 1] = num_list[length] - num_list[length - 1];
        } else {
            array[length + 1] = num_list[length] * 2;
        }

        return array;
    }
}