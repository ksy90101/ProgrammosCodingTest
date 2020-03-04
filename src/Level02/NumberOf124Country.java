package Level02;

/**
 * @ClassName : NumberOf124Country
 * @ProblemName : 124나라의 숫자
 * @URL :https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class NumberOf124Country {
    public static void main(String[] args) {
        NumberOf124Country numberOf124Country = new NumberOf124Country();
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;
        System.out.println(numberOf124Country.solution(n1));
        System.out.println(numberOf124Country.solution(n2));
        System.out.println(numberOf124Country.solution(n3));
        System.out.println(numberOf124Country.solution(n4));
    }

    public String solution(int n) {
        String[] countryNumbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            answer.insert(0, countryNumbers[n % 3]);
            n = (n - 1) / 3;
        }

        return answer.toString();
    }
}
