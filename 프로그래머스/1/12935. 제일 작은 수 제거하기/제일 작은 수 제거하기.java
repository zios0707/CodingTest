class Solution {
    public int[] solution(int[] arr) {
        int index = 0;
        for(int i = 1; i < arr.length; i++) if(arr[index] > arr[i]) index = i;
        int[] newArr = new int[arr.length - 1];
        for(int i = 0; i < arr.length; i++) 
            if(i < index) newArr[i] = arr[i];
            else if(i > index) newArr[i - 1] = arr[i];
        
        if(newArr.length != 0) return newArr;
        else return new int[]{-1};
    }
}