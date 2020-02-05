package Level01;

import java.util.Arrays;

/**
 * @ClassName : XIntervalN
 * @ProblemName : x만큼 간격이 있는 n개의 숫자
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class XIntervalN {
    public long[] solution(int x, int n){
        long[] answer = new long[n];

        answer[0] = x;

        for (int i = 1; i < n; i++){
            answer[i] = answer[i-1] + x;
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        XIntervalN xIntervalN = new XIntervalN();
        int x1 = 2;
        int x2 = 4;
        int x3 = -4;

        int n1 = 5;
        int n2 = 3;
        int n3 = 2;

        System.out.println(Arrays.toString(xIntervalN.solution(x1, n1)));
        System.out.println(Arrays.toString(xIntervalN.solution(x2, n2)));
        System.out.println(Arrays.toString(xIntervalN.solution(x3, n3)));
    }
}
