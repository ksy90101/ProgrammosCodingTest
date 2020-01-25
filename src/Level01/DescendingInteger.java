package Level01;

import java.util.Arrays;

/**
 * @ClassName : DescendingInteger
 * @ProblemName : 정수 내림차순으로 배치하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class DescendingInteger {
    public long solution(long n){
        long answer;
        char[] nArray = Long.toString(n).toCharArray();

        Arrays.sort(nArray);

        StringBuffer stringBuffer = new StringBuffer();

        for (char n1 : nArray){
            stringBuffer.append(n1);
        }

        stringBuffer.reverse();

        answer = Long.parseLong(stringBuffer.toString());

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        DescendingInteger descendingInteger = new DescendingInteger();
        int n = 118372;

        System.out.println(descendingInteger.solution(n));
    }
}
