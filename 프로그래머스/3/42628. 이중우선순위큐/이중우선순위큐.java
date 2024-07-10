import java.util.LinkedList;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        Integer firstNum = null;
        for (String s : operations) {
            String command = s.split(" ")[0];
            Integer value = Integer.parseInt(s.split(" ")[1]);

            if (command.equals("I")) { // Insert

                if(firstNum == null) {
                    firstNum = value;
                    list.push(firstNum);
                }else {
                    Integer idx = 0;

                    if(value > firstNum) {

                        while (!list.isEmpty() && idx < list.size() - 1) {
                            if (list.get(idx) < value) break;
                            idx++;
                        }

                        list.add(idx, value);
                    }else {
                        idx = list.size();
                        while (!list.isEmpty() && idx > 0) {
                            if (list.get(idx - 1) > value) break;
                            idx--;
                        }

                        list.add(idx, value);
                    }
                }

                if (!list.contains(firstNum)) firstNum = (list.isEmpty() ? null : list.peekFirst());
            }else { // Delete
                if (!list.isEmpty()) {
                    if(value == 1) { // At Front
                        list.removeFirst();
                    }else { // At Back
                        list.removeLast();
                    }
                }
            }
        }

        if (list.isEmpty()) list.addFirst(0);

        return new int[]{list.peekFirst(), list.peekLast()};
    }
}