# [프로그래머스] 코딩테스트 연습

## [짝수와 홀수](https://programmers.co.kr/learn/courses/30/lessons/12937)

### 간략한 문제 풀이

- 3항 연산자로 if문만 아신다면 손쉽게 풀수 있습니다. 짝수 홀수는 if문 예제 중 가장 먼저 하는 문제입니다!

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/EvenOrOdd.java)

### 문제 및 풀이

**문제 설명**

정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

**제한 조건**

num은 int 범위의 정수입니다.

0은 짝수입니다.

**입출력 예**

| num | return |
| :---: | :---: |
| 3 | Odd |
| 4 | Even |

````
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
````