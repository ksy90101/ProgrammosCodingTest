package Level02;

import java.util.Arrays;

/**
 * @ClassName : StockPrice
 * @ProblemName : 주식가격
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(stockPrice.solution(prices)));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else {
                    answer[i] = count + 1;
                    break;
                }
                if (j == prices.length - 1) {
                    answer[i] = count;
                }
            }
        }
        return answer;
    }
}
