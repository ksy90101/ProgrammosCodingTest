# [프로그래머스] 코딩테스트 연습

## [자리수 더하기](https://programmers.co.kr/learn/courses/30/lessons/12931)

### 간략한 문제 풀이

- 어렵지 않았던 문제로, 저와 같이 각 자릿수를 나눠서 배열에 넣는 방법과 10을 나눠서 몫을 다음 값으로 남겨두고, 나머지는 자릿수 값일테니깐, 그걸 더하는 방법도 있습니다.

- 사실, 두번째 방법이 리소스 면에서는 더 좋을 것 같습니다. 왜냐하면 String배열을 만들기도 하며, 메소드까지 써야 되는 상황이기 때문에, 단순 연산으로 끝나는거에 비해 더 리소스 면에서는 좋을 것 같습니다.

- [github](https://github.com/ksy90101/ProgrammosCodingTest/blob/master/src/Level01/SumDigit.java)
    
### 문제 및 풀이

**문제 설명**

자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

**제한사항**

N의 범위 : 100,000,000 이하의 자연수

**입출력 예**

| N | answer |
| :---: | :---: |
| 123 | 6 |
| 987 | 24 |

**입출력 예 설명**

**입출력 예 #1**

문제의 예시와 같습니다.

**입출력 예 #2**

9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.

````
/**
 * @ClassName : SumDigit
 * @ProblemName : 자릿수 더하기
 * @URL : https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class SumDigit {
    public int solution(int n) {
        int answer = 0;
        String[] digits = Integer.toString(n).split("");

        for (int i = 0; i < digits.length; i++){
            answer += Integer.parseInt(digits[i]);
        }

        return answer;
    }

    // Test Case
    public static void main(String[] args) {
        SumDigit sumDigit = new SumDigit();
        int n1 = 123;
        int n2 = 987;

        System.out.println(sumDigit.solution(n1));
        System.out.println(sumDigit.solution(n2));
    }
}
````