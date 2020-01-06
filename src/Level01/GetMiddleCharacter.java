package Level01;

/**
 * @ClassName : GetMiddleCharacter
 * @ProblemName : 가운데 글자 가져오기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class GetMiddleCharacter {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else if (s.length() % 2 == 1) {
            answer = s.substring(s.length() / 2, s.length() / 2 + 1);
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        GetMiddleCharacter getMiddleCharacter = new GetMiddleCharacter();

        System.out.println(getMiddleCharacter.solution(s1));
        System.out.println(getMiddleCharacter.solution(s2));
    }
}
