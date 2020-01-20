# [프로그래머스] 코딩테스트 연습

## [약수의 합](https://programmers.co.kr/learn/courses/30/lessons/12928)

### 간략한 문제 풀이

- for문과 Stream으로 양쪽에서 풀어봤는데, 예전에 풀었던 [두 숫자 사이의 합](https://rutgo.tistory.com/416?category=808714)문제와 동일하게 stream이 효율성에서 더 낮게 나왔다..

- 크게 어려운 점은 없었으니, 따로 추가할 내용은 없을 듯 하다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/DivisorSum.java)

### 문제 및 풀이

**문제 설명**

정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

**제한 사항**

n은 0 이상 3000이하인 정수입니다.

**입출력 예**

| n | return | 
| :---: | :---: | 
| 12 | 28 | 
| 5 | 6 | 

**입출력 예 설명**

**입출력 예 #1**

12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

**입출력 예 #2**

5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

````
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
````