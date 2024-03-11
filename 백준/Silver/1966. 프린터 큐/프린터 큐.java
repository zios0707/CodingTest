import java.util.*;

// java 17
public class Main {
    public static void main(String[] args) {
        // init
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();

        for (int oo = 0; oo < o; oo++) {
            int[] map = new int[10];
            int n = sc.nextInt(), m = sc.nextInt();

            ArrayList<Element> array = new ArrayList<>();
            for (int nn = 0; nn < n; nn++) {
                int importance = sc.nextInt();
                map[importance]++;
                array.add(new Element(importance, m == nn));
            }

            int cnt = 1;
            while(true) {
                Element it = array.get(0);
                array.remove(it);
                boolean tkn = false;
                for (int i = 9; i > it.importance && !tkn; i--) if (map[i] > 0) tkn = true;

                if(tkn) array.add(it);
                else if(it.isChosen) {
                    System.out.println(cnt);
                    break;
                }else {
                    map[it.importance]--;
                    cnt++;
                }
            }




        }


    }
}

class Element {
    int importance;

    boolean isChosen;

    public Element(int i, boolean b) {
        importance = i;
        isChosen = b;
    }
}