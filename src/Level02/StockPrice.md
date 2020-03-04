# [프로그래머스] 코딩테스트 연습

## [주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584)

### 간략한 문제 풀이

- 0번째 인덱스 값은 자기보다 낮은 값이 나올때 마다 비교를 해야 하며, 1번째 인덱스 값도 자기보다 낮은 값이 나올때 마다 비교를 해야 합니다.

- 일단, 첫번째 for문으로 `0~배열길이-1`까지의 인덱스를 만들었습니다.

- 두번째 for문은 `비교할 인덱스 + 1 ~ 배열길의 -1`까지의 인덱스를 만들었습니다.

- 비교할 인덱스 값보다 높거나 같은 값이 나오면 계속해서 `second`를 `1초`씩 더했습니다.

- 비교할 인덱스보다 낮은 값이 나오면 지금까지 계산한 것과 +1을 해줬습니다.

- 왜냐하면, 예제에서 3초 시점의 3은, 4초 시점이 2로 바로 떨어졌지만, `1초`를 인정하기 떄문입니다.

- 또한, 맨 마지막 인덱스까지 비교했을 경우 계속해서 값이 떨어지지 않았다면, `answer`에 값이 들어가지 않아 명시적으로 조건문을 적어줬습니다.

- 전형적인 알고리즘 문제로 조금만 생각해본다면 어렵지 않게 풀수 있던 문제였던 것 같습니다.

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level02/StockPrice.java)

### 문제 및 풀이

**문제 설명**

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

**제한사항**
- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
- prices의 길이는 2 이상 100,000 이하입니다.

**입출력 예**
| price | return |
| :---: | :---: |
| [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0] | 

**입출력 예 설명**
- 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
- 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
- 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
- 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
- 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

````java
package Level02;

import java.util.Arrays;

/**
 * @ClassName : StockPrice
 * @ProblemName : 주식가격
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int second = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    second++;
                } else {
                    answer[i] = second + 1;
                    break;
                }
                if (j == prices.length - 1) {
                    answer[i] = second;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(stockPrice.solution(prices)));
    }
}
````