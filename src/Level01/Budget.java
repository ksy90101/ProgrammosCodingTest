package Level01;

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
