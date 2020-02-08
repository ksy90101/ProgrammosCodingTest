# [프로그래머스] 코딩테스트 연습

## [예산](https://programmers.co.kr/learn/courses/30/lessons/12982)

### 간략한 문제 풀이

- 처음 문제를 읽어보고 들었던 생각은 작은 수 부터 넣다가 예산에서 벗어나면 그게 제일 많이 지원할 수 있는 길이 아닐까 생각해서 코드 방향을 그렇게 잡았습니다.

- 다행이게도 처음에 생각한 방향이 맞았으며, 배열을 정렬하여 작은 수부터 더하면서 부서 수를 세었고, 최대 예산과 비교하여 더 크면 그때 for문을 빠져나가도록 구현하였습니다

- [Arrays.sort()](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Arrays.html#sort(byte[]\))
    - public static void sort(int[] a)
    - 매개변수(Parameters)로 들어온 배열을 오름차순으로 정렬합니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/Budget.java)

### 문제 및 풀이

**문제 설명**

S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다. 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다. 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.

물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.

부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.

**제한사항**

d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.

d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.

budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.

**입출력 예**

| d | budget | result |
| :---: | :---: | :---: |
| [1,3,2,5,4] | 9 | 3 |
| [2,2,3,3] | 10 | 4 | 

**입출력 예 설명**

**입출력 예 #1**

각 부서에서 [1원, 3원, 2원, 5원, 4원]만큼의 금액을 신청했습니다. 만약에, 1원, 2원, 4원을 신청한 부서의 물품을 구매해주면 예산 9원에서 7원이 소비되어 2원이 남습니다. 항상 정확히 신청한 금액만큼 지원해 줘야 하므로 남은 2원으로 나머지 부서를 지원해 주지 않습니다. 위 방법 외에 3개 부서를 지원해 줄 방법들은 다음과 같습니다.

1원, 2원, 3원을 신청한 부서의 물품을 구매해주려면 6원이 필요합니다.

1원, 2원, 5원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.

1원, 3원, 4원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.

1원, 3원, 5원을 신청한 부서의 물품을 구매해주려면 9원이 필요합니다.

3개 부서보다 더 많은 부서의 물품을 구매해 줄 수는 없으므로 최대 3개 부서의 물품을 구매해 줄 수 있습니다.

**입출력 예 #2**

모든 부서의 물품을 구매해주면 10원이 됩니다. 따라서 최대 4개 부서의 물품을 구매해 줄 수 있습니다.

````
import java.util.Arrays;

/**
 * @ClassName : Budget
 * @ProblemName : 예산
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12982
 */
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int maxSupport = 0;

        Arrays.sort(d);

        for (int departmentBudget : d) {
            maxSupport += departmentBudget;
            if (maxSupport > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        Budget budget = new Budget();
        int[] d1 = {1, 3, 2, 5, 4};
        int[] d2 = {2, 2, 3, 3};
        int budget1 = 9;
        int budget2 = 10;

        System.out.println(budget.solution(d1, budget1));
        System.out.println(budget.solution(d2, budget2));
    }
}
````