package Level01;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName : DescendingString
 * @ProblemName : 문자열 내림차순으로 배치하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class DescendingString {

    public String solution(String s) {
        String answer = "";
        String[] sArray = s.split("");
        Arrays.sort(sArray);

        Collections.reverse(Arrays.asList(sArray));

        answer = String.join("", sArray);

        return answer;
    }

    //TestCase
    public static void main(String[] args) {
        DescendingString descendingString = new DescendingString();

        String s = "Zbcdefg";

        System.out.println(descendingString.solution(s));
    }
}
