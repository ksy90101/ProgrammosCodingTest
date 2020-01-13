package Level01;

/**
 * @ClassName : BetweenNumberSum
 * @ProblemName : 두 정수 사이의 합
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class BetweenNumberSum {
    public long solution(int a, int b) {
        long answer = 0;

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        BetweenNumberSum betweenNumberSum = new BetweenNumberSum();

        int a1 = 3;
        int a2 = 3;
        int a3 = 5;

        int b1 = 5;
        int b2 = 3;
        int b3 = 3;

        System.out.println(betweenNumberSum.solution(a1, b1));
        System.out.println(betweenNumberSum.solution(a2, b2));
        System.out.println(betweenNumberSum.solution(a3, b3));
    }
}
