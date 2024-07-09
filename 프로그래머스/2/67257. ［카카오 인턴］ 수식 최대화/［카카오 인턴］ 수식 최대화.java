import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long solution(String expression) {
        Long result = 0L;
        String[] sampleOps = new String[]{"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
        
        String opRGX = "[*+-]";
        String numRGX = "[0-9]+";

        for (int k = 0; k < 6; k++) {
            String sampleOp = sampleOps[k];
            
            List<Long> nums = new LinkedList<>();
            for (String num : expression.split(opRGX)) nums.add(Long.parseLong(num));

            List<String> ops = new LinkedList<>(Arrays.asList(expression.split(numRGX)).subList(1, nums.size()));

            for (int i = 0; i < 3; i ++) { // 연산자 3개
                char thisOp = sampleOp.charAt(i);
                for (int j = 0; j < ops.size(); j ++) {
                    if (ops.get(j).charAt(0) == thisOp) { // 연산자가 같다면 수행
                        Long first = nums.get(j);
                        Long second = nums.get(j + 1);

                        nums.remove(j);
                        nums.remove(j);
                        ops.remove(j);

                        if(thisOp - '*' == 0) { // *
                            nums.add(j, first * second);
                        }else if(thisOp - '+' == 0) { // +
                            nums.add(j, first + second);
                        }else { // -
                            nums.add(j, first - second);
                        }
                        j--;
                    }
                }
            }

            result = Math.max(result, Math.abs(nums.get(0)));
        }

        return result;
    }
}