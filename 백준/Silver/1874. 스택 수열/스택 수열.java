import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int o = Integer.parseInt(br.readLine()), top = 1;
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= o; i++) values.add(i);
        Stack<Integer> stack = new Stack<>();

        try{
            for (int i = 0; i < o; i++) {
                int n = Integer.parseInt(br.readLine());
                for (int j = top; j <= n; j++) {
                    top++;
                    sb.append("+\n");
                    stack.push(values.remove(0));
                }
                if(n != stack.pop()) throw new RuntimeException();
                sb.append("-\n");
            }
            System.out.println(sb);
        }catch (Exception e) {
            System.out.println("NO");
        }
    }
}