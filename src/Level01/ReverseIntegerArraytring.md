# [프로그래머스] 코딩테스트 연습

## [자연수 뒤집어 배열로 만들기](https://programmers.co.kr/learn/courses/30/lessons/12932)

### 간략한 문제 풀이

- StringBuffer를 사용하여, reverse메소드를 이용하여 뒤집었다.

- 처음에는 연산으로 풀려고 하는데, 아직 수학적인 알고리즘 생각은 부족한듯 하다..ㅠㅠㅠ(엄청나게 간단한 것 같은데...)

- Collection.reverse()는 [문자열 내림차순으로 배치하기](https://rutgo.tistory.com/420) 에서 사용했었으나, 이번에는 StringBuffer의 reverse도 사용하니, reverse 메소드를 외우게 된 것 같다.

- [Github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/ReverseIntegerArray.java)

### 문제 및 풀이

**문제 설명**

자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

**제한 조건**

n은 10,000,000,000이하인 자연수입니다.

**입출력 예**

| n | return |
| :---: | :---: |
| 12345 | [5,4,3,2,1] |

````
import java.util.Arrays;

/**
 * @ClassName : ReverseIntegerArray
 * @ProblemName : 자연수 뒤집어 배열로 만들기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class ReverseIntegerArray {
    public int[] solution(long n) {
        StringBuffer nString = new StringBuffer(Long.toString(n));
        int[] answer = new int[nString.length()];

        nString.reverse();

        for (int i = 0; i < nString.length(); i++) {
            answer[i] = Integer.parseInt(nString.substring(i, i + 1));
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        ReverseIntegerArray reverseIntegerArray = new ReverseIntegerArray();
        long n = 12345;

        System.out.println(Arrays.toString(reverseIntegerArray.solution(n)));
    }
}
````