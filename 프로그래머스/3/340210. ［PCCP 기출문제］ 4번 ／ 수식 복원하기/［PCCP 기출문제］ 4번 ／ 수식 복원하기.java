import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] expressions) {
        String[] answer = {};
        
        List<Expression> solvedExp = new ArrayList();
        List<Expression> unSolvedExp = new ArrayList();
        
        int formation = 1;
        boolean certainty = false;
        
        for (String s : expressions) {
            String[] temp = s.split(" ");
            
            for (String nums : temp) {
                try {
                    int thisNum = Integer.parseInt(nums);
                    
                    formation = Math.max(thisNum % 10 + 1, formation);
                    formation = Math.max(thisNum / 10 + 1, formation);
                }catch(Exception e) { }
            }
            
            Expression exp = new Expression();
            exp.a = Integer.parseInt(temp[0]);
            exp.b = Integer.parseInt(temp[2]);
            exp.op = temp[1];
            
            if (temp[4].equals("X")) {
                unSolvedExp.add(exp);
            }else {
                exp.result = Integer.parseInt(temp[4]);
                solvedExp.add(exp);
            }
        }
        // 완전한 식들에서 최대한 데이터를 추출하는 파트
            
        for(Expression e: solvedExp) {
            if (certainty) break;
                
            // 마이너스 식은 반전시켜도 똑같이 작용함
            // 이름하야 반전술식 아오 아ㅋ카
            int a = e.a, b = e.b, res = e.result;
            if(e.op.equals("-")) {
                int t = a;
                a = res;
                res = t;
            }
            
            // System.out.println(a + " " + b + " " + res);
                
            if (a % 10 + b % 10 != res % 10) {
                formation = 10 - (res % 10 + 10 - (a % 10 + b % 10));
                certainty = true;
            }else if (a / 10 + b / 10 != res / 10) {
                formation = 10 - (res / 10 - (a / 10 + b / 10));
                certainty = true;
            }
                
        }
            
        if (formation == 9) certainty = true;
        // System.out.println(formation);
            
        // 불완적한 식을 가능한한 완전한 식으로 만드는 파트
            
        for(Expression e : unSolvedExp) {
            int a = e.a, b = e.b;
            if (e.op.equals("+")) {
                if (a % 10 + b % 10 >= formation || a / 10 + b / 10 >= formation) {
                    if (!certainty) continue;
                    
                    int temp = 0;
                    if (a % 10 + b % 10 >= formation) temp += a % 10 + b % 10 - formation + 10;
                    else temp += a % 10 + b % 10;
                    
                    if (temp / 10 + a / 10 + b / 10 >= formation) temp += (a / 10 + b / 10 - formation + 10) * 10;
                    else temp += (a / 10 + b / 10) * 10;
                    
                    e.result = temp;
                }else {
                    e.result = a + b;
                }
            }else {
                if(a % 10 < b % 10) {
                    if (!certainty) continue;
                    
                    int temp = b;
                    b += -formation + 10;
                    e.result = a - b;
                }else {
                    e.result = a - b;
                }
            }
            
        }
        
        
        return unSolvedExp.stream()
            .map(Expression::toString)
            .toArray(String[]::new);
    }
    
    class Expression{
        public int a;
        public int b;
        public String op;
        public Integer result;
        
        @Override
        public String toString() {
            return a + " " + op + " " + b + " = " + ((result != null) ? result : "?");
        }
    }
}