package Level01;

/**
 * @ClassName : EvenOrOdd
 * @ProblemName : 짝수와 홀수
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12937
 */
public class EvenOrOdd {
    public String solution(int num) {
        String answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        EvenOrOdd evenOrOdd = new EvenOrOdd();
        int num1 = 3;
        int num2 = 4;

        System.out.println(evenOrOdd.solution(num1));
        System.out.println(evenOrOdd.solution(num2));
    }
}
