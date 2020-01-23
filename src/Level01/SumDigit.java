package Level01;

/**
 * @ClassName : SumDigit
 * @ProblemName : 자릿수 더하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class SumDigit {
    public int solution(int n) {
        int answer = 0;
        String[] digits = Integer.toString(n).split("");

        for (int i = 0; i < digits.length; i++){
            answer += Integer.parseInt(digits[i]);
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        SumDigit sumDigit = new SumDigit();
        int n1 = 123;
        int n2 = 987;

        System.out.println(sumDigit.solution(n1));
        System.out.println(sumDigit.solution(n2));
    }
}
