# [프로그래머스] 코딩테스트 연습

## [x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)

### 간략한 문제 풀이

- 어렵지 않았던 문제입니다. 크게 설명할 내용은 없어 보입니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/XIntervalN.java)

### 문제 및 풀이

**문제 설명**

함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

**제한 조건**

x는 -10000000 이상, 10000000 이하인 정수입니다.

n은 1000 이하인 자연수입니다.

**입출력 예**

| x | n | answer | 
| :---: | :---: | :---: | 
| 2 | 5 | [2,4,6,8,10] |
| 4 | 3 | [4,8,12] |
| -4 | 2 | [-4, -8] |

````
import java.util.Arrays;

/**
 * @ClassName : XIntervalN
 * @ProblemName : x만큼 간격이 있는 n개의 숫자
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class XIntervalN {
    public long[] solution(int x, int n){
        long[] answer = new long[n];

        answer[0] = x;

        for (int i = 1; i < n; i++){
            answer[i] = answer[i-1] + x;
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        XIntervalN xIntervalN = new XIntervalN();
        int x1 = 2;
        int x2 = 4;
        int x3 = -4;

        int n1 = 5;
        int n2 = 3;
        int n3 = 2;

        System.out.println(Arrays.toString(xIntervalN.solution(x1, n1)));
        System.out.println(Arrays.toString(xIntervalN.solution(x2, n2)));
        System.out.println(Arrays.toString(xIntervalN.solution(x3, n3)));
    }
}
````