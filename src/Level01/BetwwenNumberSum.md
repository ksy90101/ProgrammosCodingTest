# [프로그래머스] 코딩테스트 연습

## [두 정수 사이의 합](https://programmers.co.kr/learn/courses/30/lessons/12912)

### 간략한 문제 풀이

- 어렵지 않은 문제였다.

- Stream을 배워서 Stream을 사용해서 풀어봤는데, 효율성이 더 떨어지는것 같다...

- 그저 '*'다섯개 찍는 코딩을 초보자들은 for문을 사용하고, 실력자들은 출력문으로 그냥 한줄에 끝낸다고 하는데, 이번 문제를 풀면서 그 느낌을 받은 것 같다.

- 그저 반복문이 좋지 않다는 생각을 버리자!

- [for문 github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/BetweenNumberSum.java)

- [Stream github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/BetweenNumberSumStream.java)

### 문제 및 풀이

**문제 설명**

두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.

예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

**제한 조건**

a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.

a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.

a와 b의 대소관계는 정해져있지 않습니다.

**입출력 예**

| a | b | return | 
| :---: | :---: | :---: | 
| 3 | 5 | 12 | 
| 3 | 3 | 3 | 
| 5 | 3 | 12 | 

````
/**
 * @ClassName : BetweenNumberSum
 * @ProblemName : 두 정수 사이의 합
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class BetweenNumberSum {
    public long solution(int a, int b) {
        long answer = 0;

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        BetweenNumberSum betweenNumberSum = new BetweenNumberSum();

        int a1 = 3;
        int a2 = 3;
        int a3 = 5;

        int b1 = 5;
        int b2 = 3;
        int b3 = 3;

        System.out.println(betweenNumberSum.solution(a1, b1));
        System.out.println(betweenNumberSum.solution(a2, b2));
        System.out.println(betweenNumberSum.solution(a3, b3));
    }
}
````

````
import java.util.stream.LongStream;

/**
 * @ClassName : BetweenNumberSumStream
 * @ProblemName : 두 정수 사이의 합
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class BetweenNumberSumStream {
    public long solution(int a, int b) {
        long answer = 0;

        LongStream longStream = LongStream.rangeClosed(Math.min(a,b), Math.max(a,b));

        answer = longStream.sum();

        return answer;
    }

    //Test Case
    public static void main(String[] args) {
        BetweenNumberSumStream betweenNumberSum = new BetweenNumberSumStream();

        int a1 = 3;
        int a2 = 3;
        int a3 = 5;

        int b1 = 5;
        int b2 = 3;
        int b3 = 3;

        System.out.println(betweenNumberSum.solution(a1, b1));
        System.out.println(betweenNumberSum.solution(a2, b2));
        System.out.println(betweenNumberSum.solution(a3, b3));
    }
}
````