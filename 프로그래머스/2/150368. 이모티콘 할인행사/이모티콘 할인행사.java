import java.util.Arrays;

class Solution {
    int maxSubscribe; // 최대 플러스 구독자
    int maxValue; // 최대 구매 가격
    int[] sale;

    int[][] USERS;
    int[] EMOTICONS;


    public int[] solution(int[][] users, int[] emoticons) {
        sale = new int[emoticons.length];

        USERS = users;
        EMOTICONS = emoticons;

        // 탐색 시작
        dfs(0);

        return new int[]{maxSubscribe, maxValue};
    }

    private void dfs(int index) {
        if (index == EMOTICONS.length) {
            int[] result = getResult(sale);

            if (maxSubscribe < result[0] || (maxValue < result[1] && maxSubscribe == result[0])) {

                maxSubscribe = result[0];
                maxValue = result[1];

            }
        }else {
            for (int i = 40; i >= 10; i -= 10) {
                sale[index] = i;
                dfs(index + 1);
            }
        }
    }


    private int[] getResult(int[] sales) {
        int[] discounts = new int[EMOTICONS.length];
        for (int i = 0; i < discounts.length; i++) discounts[i] = discountedPrice(EMOTICONS[i], sales[i]);

        int[] buys = new int[USERS.length];

        int[] result = new int[2];
        for (int i = 0; i < buys.length; i++) {
            for (int j = 0; j < sales.length; j++) {
                if(sales[j] >= USERS[i][0]) {
                    buys[i] += discounts[j];
                }
            }
            if (buys[i] >= USERS[i][1]) result[0]++;
            else result[1] += buys[i];
        }

        return result;
    }

    private int discountedPrice(int price, int discountPer) {
        return price * (100 - discountPer) / 100;
    }
}