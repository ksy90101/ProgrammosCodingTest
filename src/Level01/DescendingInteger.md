# [프로그래머스] 코딩테스트 연습

## [문자열 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12933)

### 간략한 문제 풀이

- [문자열 내림차순으로 배치하기](https://rutgo.tistory.com/420)와 전혀 다를바 없는 문제였다.

- 정수형타입을 문자형타입으로 변경한 후에 똑같히 진행하면 되는 부분이었습니다.

- 다른 사람 풀이 보면서, 간단히 메소드와 람다를 써서 끝낸 것이 있던데, 부럽네요 ㅎㅎ

````
    String res = "";
    Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
    return Integer.parseInt(res);
````

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/DescendingInteger.java)

### 문제 및 풀이

**문제 설명**

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

**제한 조건**

n은 1이상 8000000000 이하인 자연수입니다.

**입출력 예**

| n | return |
| :---: | :---: |
| 118372 | 873211 |

````
import java.util.Arrays;

/**
 * @ClassName : DescendingInteger
 * @ProblemName : 정수 내림차순으로 배치하기
 * @URL :https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class DescendingInteger {
    public long solution(long n){
        long answer;
        char[] nArray = Long.toString(n).toCharArray();

        Arrays.sort(nArray);

        StringBuffer stringBuffer = new StringBuffer();

        for (char n1 : nArray){
            stringBuffer.append(n1);
        }

        stringBuffer.reverse();

        answer = Long.parseLong(stringBuffer.toString());

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        DescendingInteger descendingInteger = new DescendingInteger();
        int n = 118372;

        System.out.println(descendingInteger.solution(n));
    }
}
````