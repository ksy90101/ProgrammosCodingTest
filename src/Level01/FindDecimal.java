package Level01;

/**
 * @ClassName : FindDecimal
 * @ProblemName : 소수 찾기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class FindDecimal {
    public int solution(int n) {
        int answer = 1;

        for (int i = 3; i <= n; i += 2) {
            boolean isDecimal = true;

            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isDecimal = false;
                    break;
                }
            }
            answer += isDecimal ? 1 : 0;
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        FindDecimal findDecimal = new FindDecimal();
        int n1 = 10;
        int n2 = 5;

        System.out.println(findDecimal.solution(n1));
        System.out.println(findDecimal.solution(n2));
    }
}
