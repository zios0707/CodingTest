import java.util.*;
import java.util.stream.Collectors;
    class Solution {

        Map<Integer, List<Pair<String, Integer>>> map;
        // 메뉴 길이 -> (메뉴, 주문 횟수)

        List<String> charSet;

        List<String> ORDERS;

        List<Integer> RANGE;

        public String[] solution(String[] orders, int[] course) {
            RANGE = Arrays.stream(course).boxed().collect(Collectors.toUnmodifiableList());
            map = new HashMap<>();
            ORDERS = Arrays.asList(orders);
            charSet = new ArrayList<>();
            SortedSet<String> temp = new TreeSet<>();
            for (String s : orders) temp.addAll(Arrays.asList(s.split("")));
            charSet.addAll(temp);

            dfs("", 0);

            List<String> result = new ArrayList<>();

            // 결과 도출
            for (int i : course) {
                if (map.containsKey(i)) {
                    int max = map.get(i).stream().filter(j -> RANGE.stream().anyMatch(s -> s == j.first.length())).map(p -> p.second).max((i1, i2) -> i1 - i2).orElse(-1);
                    result.addAll(map.get(i).stream().filter(p -> p.second == max && RANGE.stream().anyMatch(j -> j == p.first.length())).map(p -> p.first).collect(Collectors.toUnmodifiableList()));
                }
            }

            System.out.println(map);
            System.out.println(result);

            return result.stream().sorted().collect(Collectors.toUnmodifiableList()).toArray(new String[0]);
        }

        private void dfs(String menus, int index) {
            int cnt = 0;
            for (String s : ORDERS) {
                if (isSubSet(s, menus)) cnt++;
            }

            if (cnt >= 2 && menus.length() >= 2) {
                List<Pair<String, Integer>> list = map.getOrDefault(menus.length(), new ArrayList<>());
                list.add(new Pair(menus, cnt));
                map.put(menus.length(), list);
            }

            if (cnt >= 2 || menus.isEmpty())
                for (int i = index; i < charSet.size(); i++) {
                    String thisChar = charSet.get(i);

                    dfs(menus + thisChar, i + 1);
                }
        }

        // a 가 큰 범위.
        boolean isSubSet(String a, String b) {
            return Arrays.stream(b.split("")).allMatch(a::contains);
        }
    }

    class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }