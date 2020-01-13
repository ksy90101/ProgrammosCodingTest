package Level01;

import java.util.stream.LongStream;

/**
 * @ClassName : BetweenNumberSumStream
 * @ProblemName : 두 정수 사이의 합
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class BetweenNumberSumStream {
    public long solution(int a, int b) {
        long answer = 0;

        LongStream longStream = LongStream.rangeClosed(Math.min(a,b), Math.max(a,b));

        answer = longStream.sum();

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        BetweenNumberSumStream betweenNumberSum = new BetweenNumberSumStream();

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
