package Level01;

import java.util.Arrays;

/**
 * @ClassName : ReverseIntegerArray
 * @ProblemName : 자연수 뒤집어 배열로 만들기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class ReverseIntegerArray {
    public int[] solution(long n) {
        StringBuffer nString = new StringBuffer(Long.toString(n));
        int[] answer = new int[nString.length()];

        nString.reverse();

        for (int i = 0; i < nString.length(); i++) {
            answer[i] = Integer.parseInt(nString.substring(i, i + 1));
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        ReverseIntegerArray reverseIntegerArray = new ReverseIntegerArray();
        long n = 12345;

        System.out.println(Arrays.toString(reverseIntegerArray.solution(n)));
    }
}
