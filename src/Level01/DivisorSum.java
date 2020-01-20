package Level01;

import java.util.stream.IntStream;

/**
 * @ClassName : DivisorSum
 * @ProblemName : 약수의 합
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12928
 */
public class DivisorSum {
    public int solution(int n){
        int answer = 0;

        for (int i = 1; i <= n; i++){
            answer += (n % i == 0)? i : 0;
        }

        // 위의 for문을 제거하고 아래 스트림 한줄로도 풀이가 가능하지만, 효율성이 for문이 더 좋습니다.
        //answer = IntStream.range(1, n + 1).filter(m -> n % m == 0 ).sum();

        return answer;

    }

    // Test Case
    public static void main(String[] args) {
        DivisorSum divisorSum = new DivisorSum();

        int n1 = 12;
        int n2 = 5;

        System.out.println(divisorSum.solution(n1));
        System.out.println(divisorSum.solution(n2));
    }
}
