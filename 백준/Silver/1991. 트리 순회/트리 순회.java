import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Node> map = new HashMap<>();

        int c = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < c; i++) {
            String[] vals = sc.nextLine().split(" ");

            map.put(
                    vals[0],
                    new Node(
                            vals[0],
                            vals[1],
                            vals[2]
                    )
            );
        }

        System.out.println(front(new StringBuilder(), map.get("A"), map));
        System.out.println(middle(new StringBuilder(), map.get("A"), map));
        System.out.println(back(new StringBuilder(), map.get("A"), map));

    }

    private static StringBuilder front(StringBuilder sb, Node root, Map<String, Node> map) {
        sb.append(root.name);
        if (map.containsKey(root.left)) front(sb, map.get(root.left), map);
        if (map.containsKey(root.right)) front(sb, map.get(root.right), map);

        return sb;
    }

    private static StringBuilder middle(StringBuilder sb, Node root, Map<String, Node> map) {
        if (map.containsKey(root.left)) middle(sb, map.get(root.left), map);
        sb.append(root.name);
        if (map.containsKey(root.right)) middle(sb, map.get(root.right), map);

        return sb;
    }

    private static StringBuilder back(StringBuilder sb, Node root, Map<String, Node> map) {
        if (map.containsKey(root.left)) back(sb, map.get(root.left), map);
        if (map.containsKey(root.right)) back(sb, map.get(root.right), map);
        sb.append(root.name);

        return sb;
    }

    private static class Node {
        String name;
        String left, right;

        Node(String name, String left, String right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }
}
